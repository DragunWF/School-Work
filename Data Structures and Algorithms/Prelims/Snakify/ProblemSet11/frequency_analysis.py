frequencies = {}

def sorted_print() -> None:
    frequencies

def main() -> None:
    n = int(input())
    for i in range(n):
        words = input().split(" ")
        for word in words:
            if word in frequencies:
                frequencies[word] += 1
            else:
                frequencies[word] = 1
    sorted_print()


if __name__ == "__main__":
    main()
