basket = []


def display_basket() -> None:
    for fruit in basket:
        print(f"| {fruit} |")


def lunch_time() -> None:
    while len(basket) > 0:
        option = input().upper()
        if option == "E":
            basket.pop()
        display_basket()
    print("No more fruits")


def main() -> None:
    fruit_amount = int(input("Enter your desired fruit amount: "))
    for i in range(fruit_amount):
        fruit = input(f"Fruit {i + 1}: ")
        match fruit.upper():
            case "A": basket.append("Apple")
            case "O": basket.append("Orange")
            case "M": basket.append("Mango")
            case "G": basket.append("Guava")
    lunch_time()


if __name__ == "__main__":
    main()
