import java.util.*;

public class FoodShopping {
    private static final Scanner input = new Scanner(System.in);
    private static HashMap<String, Integer> menu = new HashMap<String, Integer>();
    private static ArrayList<String> cart = new ArrayList<String>();
    private static int balance = 0, foodCosts = 0;

    public static void main(String[] args) {
        placeMenuItems();
        displayMenu();
        askForBalance();

        while (orderFood()) {
            displayCart();
            int totalPrice = getTotalPrice();
            foodCosts = totalPrice;
            System.out.printf("\nTotal Price: %s\n", totalPrice);
        }
        askForAddOns();

        String payment;
        do {
            String paymentChoice = userInput("What is your payment method? (credit/cash) ");
            payment = paymentChoice.toLowerCase();
        } while (!payment.equals("credit") && !payment.equals("cash"));

        if (foodCosts > balance) {
            System.out.println("You don't have enough money! Shoo");
        } else {
            balance -= foodCosts;
            System.out.printf(
                "\nYou have paid in %s. Your change is %s PHP\n", payment, balance
            );
            System.out.println("\nThank you for shopping!");
        }
    }

    private static boolean orderFood() {
        String userChoice = userInput("Would you like to order food/drink? (y/n) ");
        if (userChoice.equals("yes") || userChoice.equals("y")) {
            while (true) {
                String foodChoice = userInput("What food would you like to buy? ").toLowerCase();
                if (menu.containsKey(foodChoice)) {
                    System.out.printf("%s has been added to your cart!\n", foodChoice);
                    cart.add(foodChoice);
                    return true;
                } else {
                    System.out.println("\nThat isn't on our menu! Try again...\n");
                }
            }
        }
        return false;
    }

    
    private static void askForAddOns() {
        String userChoice = userInput(
            "Would you like to add some sauce as an add on? It costs 25 PHP. (y/n) "
            );
            if (userChoice.equals("yes") || userChoice.equals("y")) {
            foodCosts += 25;
            System.out.println("Thank you for buying the AddOns!");
        }
    }
    
    private static void askForBalance() {
        do {
            String input = userInput("How much is your balance? ");
            balance = Integer.parseInt(input);
        } while (balance <= 0);
    }
    
    private static void placeMenuItems() {
        menu.put("apple", 50);
        menu.put("burger", 40);
        menu.put("rice", 15);
        menu.put("chicken", 30);
        menu.put("icecream", 80);
        menu.put("beef", 65);
        menu.put("sandwich", 35);
        menu.put("coke", 20);
        menu.put("tea", 25);
        menu.put("juice", 18);
    }
    
    private static void displayCart() {
        System.out.println("\nYour Cart:");
        if (cart.size() > 0) {
            for (String item : cart) {
                int price = menu.get(item);
                System.out.printf("%s: %s PHP\n", capitalize(item), price);
            }
        } else {
            System.out.println("(Empty)\n");
        }
    }
    
    private static void displayMenu() {
        System.out.println("\nMenu Prices");
        for (String key : menu.keySet()) {
            int value = menu.get(key);
            System.out.printf("%s: %s PHP\n", capitalize(key), value);
        }
        System.out.println();
    }
    
    private static int getTotalPrice() {
        int totalPrice = 0;
        for (String food : cart) {
            totalPrice += menu.get(food);
        }
        return totalPrice;
    }
    
    private static String capitalize(String word) {
        char[] arr = word.toCharArray();
        arr[0] = (char)((int)arr[0] - 32);
        return String.valueOf(arr);
    }
    
    private static String userInput(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }
}
