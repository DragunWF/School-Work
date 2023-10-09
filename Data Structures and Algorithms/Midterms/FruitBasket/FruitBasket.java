import java.util.Scanner;
import java.util.Stack;

public class FruitBasket {
    private static final Scanner sc = new Scanner(System.in);
    private static Stack<String> basket = new Stack<>();

    public static void main(String[] args) {
        int fruitAmount = intInput("Enter your desired fruit amount: ");
        for (int i = 0; i < fruitAmount; i++) {
            char option = charInput((i + 1) + ". Enter your fruit [Options: 'A','O','M','G']: ");
            switch (upperCase(option)) {
                case 'A' -> basket.push("Apple");
                case 'O' -> basket.push("Orange");
                case 'M' -> basket.push("Mango");
                case 'G' -> basket.push("Guava");
                default -> System.out.println("Unknown fruit!");
            }
        }
        while (basket.size() > 0) {
            displayBasket();
            char option = charInput("Enter 'E' or 'e' to start eating: ");
            if (upperCase(option) == 'E') {
                basket.pop();
            }
        }
        System.out.println("No more fruits");
    }

    private static void displayBasket() {
        if (basket.size() > 0) {
            System.out.printf("Top of the basket: %s\n", basket.peek());
        }
        Object[] contents = basket.toArray();
        for (int i = 1; i < contents.length; i++) {
            System.out.printf("| %s |\n", contents[i]);
        }
    }

    private static char upperCase(char character) {
        if (character >= 97 && character <= 122) {
            return (char) (character - 32);
        }
        return character;
    }

    private static int intInput(String prompt) {
        System.out.print(prompt);
        return sc.nextInt();
    }

    private static char charInput(String prompt) {
        System.out.print(prompt);
        return sc.next().charAt(0);
    }
}
