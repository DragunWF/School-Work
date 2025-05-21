# Marc Plarisan | BSIT601 | Programming Languages
# 07 Laboratory Exercise 1 - Task C

def main() -> None:
    enter_password()


def enter_password() -> None:
    CORRECT_PASSWORD = "default123"

    entered_password = input("Password: ")
    if entered_password == CORRECT_PASSWORD:
        print("You have entered the correct password!")
        return

    print("Incorrect password!")
    return enter_password()


if __name__ == "__main__":
    main()
