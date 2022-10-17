import java.util.Scanner;

public class AreaOfATriangle {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        final double height = userInput("Enter height: ");
        final double base = userInput("Enter base: ");
        final double area = base * height / 2;
        System.out.println(String.format("Area of the triangle: %s", area));
    }

    private static double userInput(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                return input.nextDouble();
            } catch (Exception error) {
                System.out.println("Please provide proper input");
            }
        }
    }
}
