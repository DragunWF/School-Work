group_1, group_2, self = set(), set(), set()
CLASSMATE_COUNT = 6

def main() -> None:
    for i in range(1, CLASSMATE_COUNT + 1):
        if i <= 3:
            group_1.add(input_month(f"Enter birth month {i}: "))
        else:
            group_2.add(input_month(f"Enter birth month {i - 3}: "))
    self.add(input_month("Enter your birth month: "))

    union = group_1 | group_2
    print(f"Union: {group_1 | group_2}")
    print(f"Intersection: {group_1 & group_2}")
    print(f"Difference: {group_1 - group_2}")

    if list(self)[0] in union:
        print("You have the same birth month as one of your classmates")
    else:
        print("You don't have the same birth month as any of your classmates")


def input_month(prompt: str) -> str:
    months = ("january", "february", "march", "april", "may", "june",
              "july", "august", "october", "november", "december")
    output = input(prompt).lower()
    if output in months:
        return output
    print("Please enter a valid month!")
    return input_month(prompt)


if __name__ == "__main__":
    main()
