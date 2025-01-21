import java.util.*;

public class Pythagorean {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        final double legA = userInput("Leg A: ");
        final double legB = userInput("Leg B: ");
        final double hypotenuse = Math.sqrt(legA * legA + legB * legB);
        System.out.println(String.format("Hypotenuse: %.2f", hypotenuse));
    }

    private static double userInput(String prompt) {
        System.out.print(prompt);
        return input.nextInt();
    }
}
