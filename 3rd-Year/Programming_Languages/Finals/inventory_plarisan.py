# Marc Plarisan | BSIT601 | Programming Languages
# Finals - 08 Laboratory Exercise 1

def main() -> None:
    inventory = [100, 200, 150]
    add_to_stock(inventory)
    print(f"Outside function (stock): {inventory}\n")

    base_price = 250.0
    update_price(base_price)
    print(f"Outside function (price): {base_price}")


def add_to_stock(stock_list: list) -> None:
    stock_list.append(75)
    print(f"Inside function (stock): {stock_list}")


def update_price(price: float) -> None:
    # Actually not necessary to wrap (price * 0.1) with parenthesis due to PEMDAS
    # But the instructions want it so here it is regardless...
    new_price = price + (price * 0.1)
    print(f"Inside function (price): {new_price}")


if __name__ == "__main__":
    main()
