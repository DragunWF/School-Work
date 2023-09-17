import java.util.*;

public class FriendActivity {
    private static final Scanner input = new Scanner(System.in);
    private static final String[] shapes = { "Square", "Triangle", "Rectangle" };
    private static final String apology = "Invalid Choice!";

    public static void main(String[] args) {
        printChoiceMenu("Polygon Calculator", new String[] { "Area Calculator", "Perimeter Calculator" });
        
        final int choice = choice();
        switch (choice) {
            case 1:
                areaCalculator();
                break;
            case 2:
                perimeterCalculator();
                break;
            default:
                System.out.println(apology);
                break;
        }
    }
    
    private static void areaCalculator() {
        printChoiceMenu("Area Calculator!", shapes);
        final String resultName = "area";
        double height;
        
        final int choice = choice();
        printTitle(choice);
        switch (choice) {
            case 1:
                double length = userInput("Enter Length of Side");
                printResult(length * length, shapes[choice - 1], resultName);
                break;
            case 2:
                height = userInput("Enter height");
                double base = userInput("Enter base");
                printResult((height * base) / 2, shapes[choice - 1], resultName);
                break;
            case 3:
                double width = userInput("Enter width");
                height = userInput("Enter height");
                printResult(width * height, shapes[choice - 1], resultName);
                break;
            default:
                System.out.println(apology);
                break;
        }
    }
    
    private static void perimeterCalculator() {
        printChoiceMenu("Perimeter Calculator!", shapes);
        final String resultName = "perimeter";
        double length;
        
        final int choice = choice();
        printTitle(choice);
        switch (choice) {
            case 1:
                length = userInput("Enter Length of Side");
                printResult(4 * length, shapes[choice - 1], resultName);
                break;
            case 2:
                int sum = 0;
                for (int i = 1; i <= 3; i++) {
                    sum += userInput(String.format("Enter side %s", i));
                }
                printResult(sum, shapes[choice - 1], resultName);
                break;
            case 3:
                length = userInput("Enter Length");
                double width = userInput("Enter Width");
                printResult(2 * (length + width), shapes[choice - 1], resultName);
                break;
            default:
                System.out.println(apology);
                break;
        }
    }
    
    private static void printChoiceMenu(String title, String[] choices) {
        System.out.println(title);
        for (int i = 0; i < choices.length; i++) {
            System.out.printf("[%s] %s\n", i + 1, choices[i]);
        }
    }
    
    private static void printResult(double result, String shape, String resultName) {
        System.out.printf("The %s of a %s is %s!\n", resultName, shape, result);
    }
    
    private static void printTitle(int choice) {
        if (choice >= 0 && choice < shapes.length) {
            System.out.printf("Area of %s!\n", shapes[choice - 1]);
        }
    }
    
    private static int choice() {
        return (int)userInput("Choice");
    }
    
    private static double userInput(String prompt) {
        System.out.printf("%s: ", prompt);
        return input.nextDouble();
    }
}