def main() -> None:
    CLASSMATE_COUNT = 3
    students = {}
    third_entry_key = None
    for i in range(1, CLASSMATE_COUNT + 1):
        key = input(f"Enter student number {i}: ")
        students[key] = input(f"Enter first name {i}: ")
        if i == 3:
            third_entry_key = key
    print_student_list(students)

    del students[third_entry_key]
    students[input("Enter your student number: ")] = input("Enter your first name")
    print_student_list(students)


def print_student_list(students: dict) -> None:
    print("Student List:")
    for key in students:
        print(f"{key} {students[key]}")


if __name__ == "__main__":
    main()
