# Marc Plarisan | BSIT601 | Programming Languages
# 07 Laboratory Exercise 1 - Task D

def main() -> None:
    simulate_login()


def simulate_login() -> None:
    CORRECT_PASSWORD = "default123"
    MAX_ATTEMPTS = 3

    attempts = 0
    is_correct_password = False
    while attempts < MAX_ATTEMPTS:
        entered_password = input("Password: ")
        is_correct_password = entered_password == CORRECT_PASSWORD
        attempts += 1
        print(f"Attempts: {attempts}")

        if is_correct_password:
            break

    print("Access denied" if not is_correct_password else "Login successful")


if __name__ == "__main__":
    main()
