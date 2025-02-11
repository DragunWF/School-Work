from rich import print


valid_operations = ("addition", "subtraction", "multiplication", "division")


def main() -> None:
    print(f"Valid Operations: {valid_operations}")

    operation = input_operation()
    first_num = input_num("first number")
    second_num = input_num("second number")
    result = perform_operation(operation, first_num, second_num)

    if not result is None:
        print(f"Result: {result}")


def input_num(num_name: str) -> float:
    try:
        return float(input(f"Enter the {num_name}: ").strip())
    except Exception:
        print("Please enter a valid number!")
        return input_num(num_name)


def input_operation() -> str:
    operation = input("Operation: ").lower()
    if not operation in valid_operations:
        print(f"Invalid operation! Valid inputs are {valid_operations}")
        return input_operation()
    return operation


def perform_operation(operation: str, first_num: float, second_num: float) -> float | None:
    try:
        results = {"addition": first_num + second_num,
                   "subtraction": first_num - second_num,
                   "multiplication": first_num * second_num,
                   "division": first_num / second_num}
        return results[operation]
    except ZeroDivisionError:
        print("You cannot divide by zero!")


if __name__ == "__main__":
    main()
