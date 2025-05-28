# Marc Plarisan | BSIT601 | Programming Languages
# Finals - 08 Performance Task 1

def main() -> None:
    # Defined according to the instructions
    CUSTOMER_SESSION_COUNT = 3
    SESSION_COUNTER_DEMONSTRATION_COUNT = 5

    # Instruction #3 (Calling both functions three times)
    print("===== Customer Sessions ===== ")
    for i in range(CUSTOMER_SESSION_COUNT):
        session_counter()
        kiosk_usage()

    # Instruction #4 - Calling session_counter() five times to show it resets
    print("\n===== Session Counter Demonstration ===== ")
    for i in range(SESSION_COUNTER_DEMONSTRATION_COUNT):
        session_counter()


def session_counter() -> None:
    counter = 0
    counter += 1
    print(f"Session visits: {counter}")


def kiosk_usage() -> None:
    if not hasattr(kiosk_usage, "total_users"):
        kiosk_usage.total_users = 0
    kiosk_usage.total_users += 1
    print(f"Total users today: {kiosk_usage.total_users}")


if __name__ == "__main__":
    main()
