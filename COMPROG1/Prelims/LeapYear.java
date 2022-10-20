import java.util.Scanner;

public class LeapYear {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the year:");
        int yr = input.nextInt();
        boolean leap = yr % 4 == 0 && yr % 100 != 0;
        if (!leap && yr % 400 == 0) leap = true;
        System.out.println(leap ? "It is a leap year" : "It is not a leap year");
    }
}
