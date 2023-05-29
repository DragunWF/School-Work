import java.util.Scanner;
import java.util.ArrayList;

public class CheckAnswer {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("LCM Mode:");
        int firstNum = userInput("Enter the first num: ");
        int secondNum = userInput("Enter the second num: ");
        System.out.printf("LCM(%s, %s) = %s\n", firstNum, secondNum, lcm(firstNum, secondNum));
    }

    private static int lcm(int num, int otherNum) {
        ArrayList<Integer> multiples = new ArrayList<>();
        int multiplier = 1;
        while (true) {
            int multiple = num * multiplier;
            int otherMultiple = otherNum * multiplier;

            if (multiples.contains(multiple)) {
                return multiple;
            }
            if (multiples.contains(otherMultiple)) {
                return otherMultiple;
            }

            multiples.add(multiple);
            multiples.add(otherMultiple);
            multiplier++;
        }
    }

    private static int userInput(String prompt) {
        System.out.printf("%s: ", prompt);
        int output;
        try {
            output = sc.nextInt();
        } catch (NumberFormatException err) {
            return userInput(prompt);
        }
        return output;
    }
}