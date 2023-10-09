import java.util.Scanner;
import java.util.Stack;

public class FruitBasket {
    private static final Scanner sc = new Scanner(System.in);
    private static Stack<String> basket = new Stack<>();

    public static void main(String[] args) {
        System.out.println("Catch and eat any of these fruits:('apple', 'orange', 'mango', 'guava')");
        int fruitAmount = intInput("How many fruits would you like to catch? ");
        System.out.println("Choose a fruit to catch. Press A, O, M, or G");
        for (int i = 0; i < fruitAmount; i++) {
            char option = charInput(String.format("Fruit %s of %s ", i + 1, fruitAmount));
            switch (upperCase(option)) {
                case 'A' -> basket.push("Apple");
                case 'O' -> basket.push("Orange");
                case 'M' -> basket.push("Mango");
                case 'G' -> basket.push("Guava");
                default -> System.out.println("Unknown fruit!");
            }
        }

        System.out.printf("Your basket now has: %s\n", showBasket());
        final int INITIAL_LENGTH = basket.size();
        while (basket.size() > 0) {
            if (basket.size() < INITIAL_LENGTH) {
                System.out.printf("Fruit(s) in the basket: %s\n", showBasket());
            }
            char option = charInput("Enter 'E' or 'e' to start eating ");
            if (upperCase(option) == 'E') {
                basket.pop();
            }
        }
        System.out.println("No more fruits");
    }

    private static String showBasket() {
        Object[] fruits = basket.toArray();
        String output = "[";
        for (int i = 0; i < fruits.length; i++) {
            output += String.valueOf(fruits[i]);
            if (i + 1 < fruits.length) {
                output += ", ";
            }
        }
        return output + "]";
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
