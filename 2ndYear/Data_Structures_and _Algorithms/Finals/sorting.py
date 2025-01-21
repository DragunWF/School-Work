from rich import print
from tabulate import tabulate


def main() -> None:
    bubble_sort([21, 4, 25, 16])
    selection_sort([21, 4, 25, 16, 12, 17])
    insertion_sort([21, 4, 25, 16, 12])
    shell_sort([21, 4, 25, 16, 12, 17])
    merge_sort([21, 4, 25, 16, 12, 17, 3, 30])


def bubble_sort(values: list) -> None:
    print("Bubble Sort:")
    for i in range(len(values)):
        is_sorted = True
        for j in range(len(values) - 1):
            if values[j] > values[j + 1]:
                print_table(values)
                values[j], values[j + 1] = values[j + 1], values[j]
                is_sorted = False
        if is_sorted:
            break
    print_table(values)


def selection_sort(values: list) -> None:
    print("Selection Sort:")
    for i in range(len(values)):
        min_value, min_index = values[i], i
        for j in range(i + 1, len(values) - 1):
            if values[j] < min_value:
                min_value, min_index = values[j], j
        values[i], values[min_index] = values[min_index], values[i]
        print_table(values)
    print_table(values)


def insertion_sort(values: list) -> None:
    print("Insertion Sort:")
    n = len(values)  # Get the length of the valuesay
    for i in range(1, n):
        key = values[i]
        j = i - 1
        while j >= 0 and key < values[j]:
            values[j+1] = values[j]
            j -= 1
        values[j+1] = key
        print_table(values)


def shell_sort(values: list) -> None:
    print("Shell Sort:")


def merge_sort(values: list) -> None:
    pass


def print_table(values: list) -> None:
    print(tabulate([values], tablefmt="simple_grid"))


if __name__ == "__main__":
    main()
