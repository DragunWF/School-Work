# https://snakify.org/en/lessons/dictionaries_dicts/problems/frequency_analysis/


def print_frequencies(items: list) -> None:
    for list in items:
        for frequency in list:
            print(frequency[1])


def custom_items(dictionary: dict) -> list:
    output = []
    for key in dictionary:
        output.append((dictionary[key], key))
    return output


def main() -> None:
    items = []
    n = int(input())
    for i in range(n):
        frequencies = {}
        line = input().split(" ")
        for word in line:
            if not word in frequencies:
                frequencies[word] = 1
            else:
                frequencies[word] += 1
        items.append(sorted(list(custom_items(frequencies)), reverse=True))
    print_frequencies(items)


if __name__ == "__main__":
    main()
