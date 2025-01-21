def main():
    first_num = int(input("First Number: "))
    second_num = int(input("Second Number: "))
    if first_num > second_num:
        print("The first number is greater than the second number")
    elif first_num < second_num:
        print("The first number is lesser than the second number")
    else:
        print("The two numbers are equal")


if __name__ == "__main__":
    main()
