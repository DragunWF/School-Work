def main() -> None:
    CLASSMATE_COUNT = 3
    students = {}
    order_of_keys = []
    for i in range(1, CLASSMATE_COUNT + 1):
        key = input(f"Enter student number {i}: ")
        students[key] = input(f"Enter first name {i}: ")
        order_of_keys.append(key)
    print_student_list(students, order_of_keys)

    del students[order_of_keys[2]]
    user_student_number = input("Enter your student number: ")
    students[user_student_number] = input("Enter your first name: ")
    order_of_keys[2] = user_student_number
    print_student_list(students, order_of_keys)


def print_student_list(students: dict, order_of_keys: list) -> None:
    print("Student List:")
    for key in order_of_keys:
        print(f"{key} {students[key]}")


if __name__ == "__main__":
    main()
