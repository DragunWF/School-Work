import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int BOOKS_COUNT = 4;
    private static Stack<String> books = new Stack<>();
    private static Queue<String> poppedBooks = new LinkedList<>();

    public static void main(String[] args) {
        enterBooks();
        popBooks();
        System.out.println("New order of books:");
        System.out.println(poppedBooks);
    }

    private static void enterBooks() {
        System.out.println("Enter four book titles.");
        for (int i = 1; i <= BOOKS_COUNT; i++) {
            books.push(input(
                    String.format("Book %s: ", i)));
        }
    }

    private static void popBooks() {
        for (int i = 0; i < BOOKS_COUNT; i++) {
            poppedBooks.add(books.pop());
        }
    }

    private static String input(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }
}