from collections import deque

movies, snacks = deque([]), deque([])
ITEM_COUNT = 3


def fill_queue(is_movie: bool) -> None:
    title = "movie" if is_movie else "snack"
    for i in range(1, ITEM_COUNT + 1):
        item = input(f"Enter {title} {i} of {ITEM_COUNT}: ")
        if is_movie:
            movies.append(item)
        else:
            snacks.append(item)


def main() -> None:
    fill_queue(True)
    fill_queue(False)
    print(f"Movies to watch are: {movies}")
    print(f"Snacks available are: {snacks}")
    while len(snacks):
        option = input("Press S each time you finish a snack")
        if option.upper() == "S":
            snacks.popleft()
        print(snacks)
    print("No more snacks")


if __name__ == "__main__":
    main()
