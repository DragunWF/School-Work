import java.util.Scanner;

public class UserYear extends Year {
    public UserYear(int number) {
        this.number = number;
    }

    public static void main(String[] args) {
        System.out.print("Enter a year: ");
        UserYear year = new UserYear(new Scanner(System.in).nextInt());
        System.out.println(year.isLeapYear() ? "Leap year" : "Not a leap year");
    }
}
