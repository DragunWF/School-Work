# Marc Plarisan | BSIT601 | Programming Languages
# 07 Laboratory Exercise 1 - Task A

def main() -> None:
    name = input_str("Name")
    age = input_num("Age")
    year = input_num("Year")
    print(f"""
    User Information:
    Name: {name}
    Age: {age}
    Year: {year}
    """)


def input_str(prompt: str) -> str:
    name = input(f" {prompt}: "). strip()
    if not name:
        print("Input must not be empty!")
        return input_str(prompt)
    return name


def input_num(prompt: str) -> int:
    try:
        num = int(input(f" {prompt}: "))
        if num <= 0:
            print("Integer must be positive!")
            return input_num(prompt)
        return num
    except ValueError:
        print("Please provide a valid positive integer!")
    return input_num(prompt)


if __name__ == "__main__":
    main()
