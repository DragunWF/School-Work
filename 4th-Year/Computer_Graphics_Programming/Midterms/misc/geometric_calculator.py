def main() -> None:
    print("Welcome to the Geometric Calculator by Marc Plarisan!")
    print("This program allows you to perform scaling and translation on 3D points.")
    print("===============================================================")
    execute_menu()


def execute_menu() -> None:
    commands = ["scale", "translation"]
    EXIT_WORD = "exit"
    print(f"Type '{EXIT_WORD}' to exit the program.")
    while True:
        print("Commands:")
        for command in commands:
            print(f" - {command}")

        user_input = input("Enter a command: ").lower().strip()
        if user_input == EXIT_WORD:
            print("Exiting the program.")
            break
        if user_input == "scale":
            try:
                x = int(input("Enter scaling factor for x: "))
                y = int(input("Enter scaling factor for y: "))
                z = int(input("Enter scaling factor for z: "))
                values = tuple(
                    int(i) for i in input("Enter the point (x, y, z) separated by spaces: ").split()
                )
                if len(values) != 3:
                    raise ValueError(
                        "You must enter exactly three integers for the point."
                    )
                result = scale(x, y, z, values)
                print(f"=========> Scaled point: {result} <=========")
            except ValueError as e:
                print(f"Invalid input: {e}")
        elif user_input == "translation":
            try:
                x = int(input("Enter translation value for x: "))
                y = int(input("Enter translation value for y: "))
                z = int(input("Enter translation value for z: "))
                values = tuple(
                    int(i) for i in input("Enter the point (x, y, z) separated by spaces: ").split()
                )
                if len(values) != 3:
                    raise ValueError(
                        "You must enter exactly three integers for the point."
                    )
                result = translation(x, y, z, values)
                print(f"=========> Translated point: {result} <=========")
            except ValueError as e:
                print(f"Invalid input: {e}")
        else:
            print("Unknown command. Please try again.")


def scale(x: int, y: int, z: int, values: tuple[int, int, int]) -> list[int]:
    values = (*values, 1)
    matrix = [
        [x, 0, 0, 0],
        [0, y, 0, 0],
        [0, 0, z, 0],
        [0, 0, 0, 1],
    ]
    return [sum(row[i] * values[i] for i in range(4)) for row in matrix]


def translation(x: int, y: int, z: int, values: tuple[int, int, int]) -> list[int]:
    matrix = [
        [x, 0, 0, values[0]],
        [0, y, 0, values[1]],
        [0, 0, z, values[2]],
        [0, 0, 0, 1],
    ]
    output = []
    for row in matrix:
        output.append(sum(row))
    return output


if __name__ == "__main__":
    main()
