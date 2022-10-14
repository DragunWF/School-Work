import java.util.Scanner;

public class MinutesToSeconds {
    public static void main(String[] args) {
        System.out.println("Enter minutes:");
        int minutes = new Scanner(System.in).nextInt();
        int seconds = minutes * 60;
        System.out.println("Seconds: " + seconds);
    }
}
