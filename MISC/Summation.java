import java.util.*;

public class Summation { // Not complete yet
    private static final Scanner input = new Scanner(System.in);
    private static final int lastIndex = 4;
    private static final int startIndex = 1;

    public static void main(String[] args) {
        int userAns = userInput("Enter your answer: ");

        int correctAns = 0;
        for (int n = startIndex; n < lastIndex; n++)
            correctAns += n;
        
        if (userAns == correctAns) {
            System.out.println("Congrats! You got the correct answer!");
        } else {
            System.out.printf("Wrong! The correct answer was %s!\n", correctAns);
        }
    }

    private static int userInput(String prompt) {
        System.out.print(prompt);
        return input.nextInt();
    }
}
