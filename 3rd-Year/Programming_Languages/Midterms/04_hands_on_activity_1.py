from sys import exit

AVAILABLE, BORROWED = "available", "borrowed"
VALID_BOOK_STATUSES = (AVAILABLE, BORROWED)
library_books = []


class Book:
    def __init__(self, id: int, name: str, status: str):
        if not status in VALID_BOOK_STATUSES:
            raise Exception(
                f"Book status is not valid!, valid statuses are {VALID_BOOK_STATUSES}"
            )
        self.__id = id
        self.__name = name
        self.__status = status

    def borrow_book(self) -> None:
        self.__status = BORROWED

    def print_details(self) -> None:
        print(f"""
Book:
ID: {self.__id}
Name: {self.__name}
Status: {self.__status}
""")

    def get_id(self) -> int:
        return self.__id

    def get_name(self) -> str:
        return self.__name

    def get_status(self) -> str:
        return self.__status


class Program:
    @staticmethod
    def main() -> None:
        Program.add_data(library_books)
        Program.play_menu()

    @staticmethod
    def add_data(target_data: list) -> None:
        book_titles = ["Atomic Habits", "Deep Work",
                       "Thinking, Fast and Slow", "Super Communicators",
                       "The 80/20 Rule", "Getting Things Done"]
        for i, title in enumerate(book_titles):
            target_data.append(Book(i + 1, title, "available"))

    @staticmethod
    def play_menu() -> None:
        while True:
            print("\nChoose a book you want to borrow:")
            Program.display_books(library_books)

            book_to_borrow = Program.book_id_input(
                "Enter the ID of the book you want to borrow (Type -1 to exit): "
            )
            if book_to_borrow == -1:
                exit()
            Program.check_out_book(book_to_borrow, library_books)

    @staticmethod
    def display_books(books: list[Book]) -> None:
        for book in books:
            book.print_details()

    @staticmethod
    def book_id_input(prompt: str) -> int:
        try:
            book_id = int(input(prompt))
            available_ids = [book.get_id() for book in library_books]
            if book_id != -1 and not book_id in available_ids:
                print("Book ID was not found!")
                return Program.book_id_input(prompt)
            return book_id
        except ValueError:
            print("Please enter a valid integer!")
            return Program.book_id_input(prompt)

    @staticmethod
    def check_out_book(book_id: int, books: list[Book]) -> None:
        book: Book = books[book_id - 1]
        if book.get_status() == BORROWED:
            print(f"{book.get_name()} has already been borrowed!")
            return

        book.borrow_book()
        print(f"{book.get_name()} has been borrowed!")


if __name__ == "__main__":
    Program.main()
