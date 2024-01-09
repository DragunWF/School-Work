from time import sleep


class User:
    def __init__(self):
        self.name = None


class Node:
    def __init__(self, func, left=None, right=None):
        self.execution = func
        self.left = left
        self.right = right

    def execute(self) -> str:
        return self.execution()


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
        while True:
            option = Utils.input(
                "Is there anything else you need help with? Please answer with a simple yes or no")
            if "y" in option or "yes" in option:
                self.traverse(self.root)
                break
            elif "n" in option or "no" in option:
                print("Thank you for interacting with me, a chatbot.")
                break
            else:
                print("Please answer with either yes or no...")


class Utils:
    @staticmethod
    def input(prompt: str) -> list[str]:
        return input(f"{prompt}\n> ").split(" ")


class Dialogue:
    @staticmethod
    def start() -> None:
        pass

    @staticmethod
    def intro() -> str:
        words = Utils.input(
            "May we help you with our store's categories or do you need to meet with the manager?")
        if "category" in words or "categories" in words:
            return "left"
        elif "manager" in words:
            return "right"
        print("I'm sorry but I don't comprehend your request. Do you need help with categories or the manager?")
        return Dialogue.intro()

    @staticmethod
    def categories(repeat: bool = False) -> None:
        print(
            "The categories available are food, utilities, school supplies, and medicine...")
        words = Utils.input("Which one would you like to know about?")
        if "food" in words:
            print("It is located at section A1 of the building. The section contains meat, diary products, and junk food.")
        elif "utility" in words or "utilities" in words:
            print("The utility section is located at section A2 of the building")
        elif "school" in words or "supplies" in words:
            print(
                "If you're looking for school supplies, it is located at section A3 of the building")
        elif "medicine" in words or "medical" in words:
            print("If you are looking for medicine, you should go to section B4 of the building which is all the way at one of the corners.")
        else:
            print(
                "I do not comprehend what your request, which category are you looking for exactly?")
            sleep(0.25)
            print("The category you are looking for may not exist, please choose the categories I listed previously...")
            sleep(0.25)
            return Dialogue.categories(True)

        while True:
            words = Utils.input(
                "Is there anything else you need help with the categories? Answer with either yes or no")
            if "y" in words or "yes" in words or "absolutely" in words:
                Dialogue.categories(True)
                break
            elif "n" in words or "no" in words or "not" in words:
                break
            else:
                print("Please answer with either yes or no...")

    @staticmethod
    def manager() -> str:
        pass


def main() -> None:
    root = Node(Dialogue.intro)
    category_node = Node(Dialogue.categories)
    manager_node = Node(Dialogue.manager)

    root.left = category_node
    root.right = manager_node

    DialogueTree(root).traverse(root)


if __name__ == '__main__':
    main()
