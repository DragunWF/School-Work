from rich import print
from collections import deque


class Item:
    def __init__(self, value: int):
        self.value = value

def main() -> None:
    items = ["Scientist", "Programmer", "Lawyer"]
    i = 0
    item_index = 0
    loops = 30
    switch = 3
    while i < loops:
        i += 1
        print(items[item_index], end=" ")
        if i % switch == 0:
            item_index += 1
            if item_index >= len(items):
                item_index = 0
    print()

def foo() -> None:
    values = deque(["macOS", "Windows", "Linux", "TempleOS"])
    while values:
        print(values[0])
        values.popleft()


def bar() -> None:
    values = [Item(3), Item(4), Item(5)]
    second = []
    item = values[0]
    print(item.value)
    second.append(values[0])
    item.value = 7
    print(values[0].value)
    print(second[0].value)
    

if __name__ == "__main__":
    # main()
    # foo()
    bar()