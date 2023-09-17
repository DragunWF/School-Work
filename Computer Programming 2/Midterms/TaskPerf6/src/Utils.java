import java.util.Scanner;

public class Utils {
    private static final Scanner input = new Scanner(System.in);

    public static String userInput(String prompt) {
        System.out.printf("%s: ", prompt);
        return input.nextLine();
    }
}
