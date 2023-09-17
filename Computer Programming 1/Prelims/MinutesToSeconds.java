import java.util.Scanner;

public class MinutesToSeconds {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter minutes:");
        int minutes = input.nextInt();
        int seconds = minutes * 60;
        System.out.println("Seconds: " + seconds);
    }
}
