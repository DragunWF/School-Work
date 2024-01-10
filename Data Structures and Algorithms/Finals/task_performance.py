from time import sleep
from typing import Callable


class Node:
    def __init__(self, func: Callable, visit_sensitive=False):
        self.left = None
        self.right = None

        self.execution = func
        self.visit_sensitive = visit_sensitive
        self.visited = False

    def execute(self) -> str:
        self.visited = True
        if not self.visit_sensitive:
            return self.execution()
        return self.execution(not self.visited)


class DialogueTree:
    def __init__(self, root: Node):
        self.root: Node = root

    def traverse(self, node: Node) -> None:
        if node != None:
            path = node.execute()
            if path == "left":
                self.traverse(node.left)
            else:
                self.traverse(node.right)

    def end(self) -> None:
        while True:
            option = Utils.input("Is there anything else you need help with? " + 
                                 "Please answer with a simple yes or no")
            sleep(2)
            if "yes" in option:
                self.traverse(self.root)
            elif "no" in option:
                print("Thank you for interacting with me.")
                break
            else:
                print("Please answer with either yes or no...")


class Utils:
    @staticmethod
    def input(prompt: str) -> list[str]:
        return input(f"{prompt}\n> ").split(" ")

    @staticmethod
    def contains(prompt: list[str], *words: list[str]) -> bool:
        for word in words:
            if word.lower() in prompt:
                return True
        return False


class Dialogue:
    @staticmethod
    def intro() -> str:
        words = Utils.input("May we help you with our store's categories or " + 
                            "do you need to meet with the manager?")
        sleep(2)
        if Utils.contains(words, "category", "categories", "sections"):
            return "left"
        elif Utils.contains(words, "manager", "managers", "boss", "master"):
            return "right"
        print("I'm sorry but I don't comprehend your request. " + 
              "Do you need help with categories or the manager?")
        return Dialogue.intro()

    @staticmethod
    def categories() -> None:
        print("The categories available are food, utilities, " + 
              "school supplies, and medicine...")
        sleep(2)

        words = Utils.input("Which one would you like to know about?")
        if "food" in words:
            print("It is located at section A1 of the building. " + 
                  "The section contains meat, diary products, and junk food.")
        elif Utils.contains(words, "utility", "utilities"):
            print("The utility section is located at section A2 of the building")
        elif Utils.contains(words, "school", "supplies", "college", "schools", "university"):
            print("If you're looking for school supplies, it is located at " + 
                  "section A3 of the building")
        elif Utils.contains(words, "medical", "medicine", "pills", "bandages", "bandage", "aid"):
            print("If you are looking for medicine, you should go to section B4 of " + 
                  "the building which is all the way at one of the corners.")
        else:
            print("I do not comprehend what your request, " + 
                  "which category are you looking for exactly?")
            sleep(1)
            print("The category you are looking for may not exist, " + 
                  "please choose the categories I listed previously...")
            sleep(1)
            return Dialogue.categories()

        while True:
            words = Utils.input("Is there anything else you need help with the categories? " + 
                                "Answer with either yes or no")
            sleep(1)
            if Utils.contains(words, "yes", "absolutely"):
                Dialogue.categories()
                break
            elif Utils.contains(words, "no", "not"):
                break
            else:
                print("Please answer with either yes or no... " + 
                      "Or you can answer with something like 'absolutely'")
                sleep(1)

    @staticmethod
    def manager(repeat=False) -> str:
        if not repeat:
            print("Do you a problem with our store that you " + 
                  "would like to report to the manager?")
        sleep(3)
        words = Utils.input("If so, is it with the employees or " + 
                            "the environment of the store?")
        if Utils.contains(words, "no", "not", "none", "don't", "dont"):
            print("I see, well you can only contact the manager " + 
                  "with problems about the store")
            sleep(2)
            print("But since you don't have any problems, " + 
                  "let's talk about something else...")
            return
        elif Utils.contains(words, "employee", "worker", "employees", "workers"):
            return "left"
        elif Utils.contains(words, "environment", "surroundings", "enviroments"):
            return "right"
        else:
            print("I do not comprehend your message, " + 
                  "is it with the employees or the environment")
            Dialogue.manager(True)
        sleep(2)

    @staticmethod
    def employees(visited=False) -> None:
        if visited:
            print("You have already reported issues about our employees and workers. " + 
                  "Please try again in our next session.")
            sleep(1)
            return
        Utils.input("What are your problems about our employees?")
        sleep(3)
        print("I see... Email us a full report for consideration. " + 
              "We have placed you on the meeting queue.")
        sleep(1)

    @staticmethod
    def environment(visited=False) -> None:
        if visited:
            print("You have already reported problems about our store's environment. " + 
                  "Please try again in our next interaction.")
            sleep(1)
            return
        Utils.input("What are your issues about our " + 
                    "store's environment and surroundings?")
        sleep(3)
        print("Affirmative, please email us a full report for consideration. " + 
              "We have now added you to the meeting queue.")
        sleep(1)


def main() -> None:
    root = Node(Dialogue.intro)
    category_node = Node(Dialogue.categories)
    manager_node = Node(Dialogue.manager)

    root.left = category_node
    root.right = manager_node

    employee_node = Node(Dialogue.employees, True)
    environment_node = Node(Dialogue.environment, True)

    manager_node.left = employee_node
    manager_node.right = environment_node

    dialogue_tree = DialogueTree(root)
    dialogue_tree.traverse(root)
    dialogue_tree.end()


if __name__ == '__main__':
    main()
