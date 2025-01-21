basket = []


def lunch_time() -> None:
    print(f"Your basket now has: {basket}")
    INITIAL_LEN = len(basket)
    while len(basket) > 0:
        if len(basket) < INITIAL_LEN:
            print(f"Fruit(s) in the basket: {basket}")
        option = input("Press E to eat a fruit. ").upper()
        if option == "E":
            basket.pop()
    print("No more fruits")


def main() -> None:
    print("Catch and eat any of these fruits:('apple', 'orange', 'mango', 'guava')")
    fruit_amount = int(input("How many fruits would you like to catch? "))
    print("Choose a fruit to catch. Press A, O, M, or G.")
    for i in range(fruit_amount):
        fruit = input(f"Fruit {i + 1} of {fruit_amount}: ")
        match fruit.upper():
            case "A": basket.append("apple")
            case "O": basket.append("orange")
            case "M": basket.append("mango")
            case "G": basket.append("guava")
    lunch_time()


if __name__ == "__main__":
    main()
