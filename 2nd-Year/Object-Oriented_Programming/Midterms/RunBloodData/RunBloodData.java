import java.util.Scanner;

public class RunBloodData {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        BloodData bd1 = createBloodData();
        bd1.display();
        System.out.println(); // for spacing and a cleaner outputs
        BloodData bd2 = createBloodData();
        bd2.display();
    }

    private static BloodData createBloodData() {
        String bloodType = input("Enter blood type of patient: ");
        String rhFactor = input("Enter the Rhesus factor (+ or -): ");
        if (bloodType.length() == 0 || rhFactor.length() == 0) {
            return new BloodData();
        }
        return new BloodData(bloodType, rhFactor);
    }

    private static String input(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }
}

class BloodData {
    private static String bloodType;
    private static String rhFactor;

    public BloodData() {
        bloodType = "O";
        rhFactor = "+";
    }

    public BloodData(String bt, String rh) {
        // Entering an invalid blood type or RH Factor will result in the default values
        if (!bt.equals("O") && !bt.equals("A") && !bt.equals("B") && !bt.equals("AB")) {
            bloodType = "O";
        } else {
            bloodType = bt;
        }
        rhFactor = !rh.equals("+") && !rh.equals("-") ? "+" : rh;
    }

    public void display() {
        System.out.printf("%s%s is added to the blood bank\n", bloodType, rhFactor);
    }
}
