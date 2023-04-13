import java.util.*;

public class NthTerm {
    private static final Scanner input = new Scanner(System.in);
    private static final int a = 1;
    private static final int d = 3;

    public static void main(String[] args) {
        System.out.printf("d = %s, a = %s\n", d, a);
        final int n = userInput("Enter n: ");
        final int userAns = userInput("Enter your answer: ");
        final int correctAns = d * n + (a - d);

        if (userAns == correctAns) {
            System.out.println("Congrats you got it right!");
        } else {
            System.out.printf("Wrong! The correct answer was %s!\n", correctAns);
        }
    }

    private static int userInput(String prompt) {
        System.out.print(prompt);
        return input.nextInt();
    }
}
