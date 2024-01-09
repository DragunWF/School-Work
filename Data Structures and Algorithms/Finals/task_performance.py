from time import sleep

class User:
    def __init__(self):
        self.name = None

class Node:
    def __init__(self, func, left = None, right = None):
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

class Utils:
    @staticmethod
    def input(prompt: str) -> list[str]:
        return input(f"{prompt} ").split(" ")

class Dialogue:
    @staticmethod
    def start() -> None:
        pass

    @staticmethod
    def intro() -> str:
        words = Utils.input("May we help you with our store's categories or do you need to meet with the manager?")
        if "category" in words or "categories" in words:
            return "left"
        elif "manager" in words:
            return "right"
        print("I'm sorry but I don't comprehend your request. Do you need help with categories or the manager?")
        return Dialogue.intro()
    
    @staticmethod
    def categories(repeat: bool = False) -> None:
        print("The categories available are food, utilities, school supplies, and medicine...")
        words = Utils.input("Which one would you like to know about?")
        if "food" in words:
            print("It is located at section A1 of the building. The section contains meat, diary products, and junk food.")
        elif "utility" in words or "utilities" in words:
            pass
        elif "school" in words or "supplies" in words:
            pass
        elif "medicine" in words or "medical" in words:
            print("")
        else:
            print("I do not comprehend what your request, which category are you looking for exactly?")
            sleep(0.25)
            print("The category you are looking for may not exist, please choose the categories I listed previously...")
            sleep(0.25)
            Dialogue.categories(True)

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
