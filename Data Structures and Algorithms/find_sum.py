def find_sum(n):
    if n == 0:
        return 0
    return n + find_sum(n - 1)


def main():
    n = int(input("Enter a number: "))
    print(find_sum(n))


if __name__ == "__main__":
    main()
