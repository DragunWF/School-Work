basket = []


def lunch_time() -> None:
    print(f"Your basket now has: {basket}")
    initial_len = len(basket)
    while len(basket) > 0:
        if len(basket) < initial_len:
            print(f"Fruit(s) in the basket: {basket}")
        option = input("Press E to eat a fruit ").upper()
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
            case "A": basket.append("Apple")
            case "O": basket.append("Orange")
            case "M": basket.append("Mango")
            case "G": basket.append("Guava")
    lunch_time()


if __name__ == "__main__":
    main()
