# Marc Plarisan | BSIT601 | Programming Languages
# 07 Laboratory Exercise 1 - Task B

def main() -> None:
    num = input_num("Enter an integer")
    if num > 0:
        print("You entered a positive integer")
    elif num < 0:
        print("You entered a negative integer")
    else:
        print("You entered zero")


def input_num(prompt: str) -> int:
    try:
        return int(input(f" {prompt}: "))
    except ValueError:
        print("Please provide a valid integer!")
        return input_num(prompt)


if __name__ == "__main__":
    main()
