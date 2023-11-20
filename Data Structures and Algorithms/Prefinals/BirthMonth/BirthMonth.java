import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class BirthMonth {
    private static final Scanner sc = new Scanner(System.in);
    private static Set<String> group1 = new HashSet<>();
    private static Set<String> group2 = new HashSet<>();
    private static Set<String> self = new HashSet<>();

    public static void main(String[] args) {
        for (int i = 1, classmates = 6; i <= classmates; i++) {
            String prompt = String.format("Enter birth month %s: ", i <= 3 ? i : i - 3);
            if (i <= 3) {
                Collections.addAll(group1, input(prompt));
            } else {
                Collections.addAll(group2, input(prompt));
            }
        }

        displaySet("Group 1: ", group1);
        displaySet("Group 2: ", group2);

        self.add(input("Enter your birth month: "));

        Set<String> union = new HashSet<>(group1);
        Set<String> intersection = new HashSet<>(group1);
        Set<String> difference = new HashSet<>(group1);
        union.addAll(group2);
        intersection.retainAll(group2);
        difference.removeAll(group2);
        displaySet("Union: ", union);
        displaySet("Intersection: ", intersection);
        displaySet("Difference: ", difference);

        if (union.containsAll(self)) {
            System.out.println("You have the same birth month as one of your classmates");
        } else {
            System.out.println("You don't have the same birth month as any of your classmates");
        }
    }

    private static void displaySet(String header, Set<String> set) {
        System.out.printf("%s: %s\n", header, set);
    }

    private static String input(String prompt) {
        String[] months = {
                "january", "february", "march", "april", "may", "june",
                "july", "august", "october", "november", "december"
        };
        System.out.print(prompt);
        String userInput = sc.nextLine().toLowerCase();
        for (String month : months) {
            if (userInput.equals(month)) {
                return userInput;
            }
        }
        System.out.println("Please enter a valid month!");
        return input(prompt);
    }
}