from rich import print
from collections import deque

# Testing for the Round Robin scheduling algorithm

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
    

if __name__ == "__main__":
    # main()
    foo()