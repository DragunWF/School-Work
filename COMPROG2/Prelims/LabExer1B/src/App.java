import java.util.Scanner;

public class App {
    private static final Scanner input = new Scanner(System.in);
    private static int number;

    public static void main(String[] args) throws Exception {
        System.out.print("Enter an integer: ");
        number = input.nextInt();
        showNumberPlus10();
        showNumberPlus100();
        showNumberPlus1000();
    }

    private static void showNumberPlus10() {
        showNumber(10);
    }

    private static void showNumberPlus100() {
        showNumber(100);
    }

    private static void showNumberPlus1000() {
        showNumber(1000);
    }

    private static void showNumber(int otherNumber) {
        final int sum = number + otherNumber;
        System.out.printf("%s plus %s is %s\n", number, otherNumber, sum);
    }
}
