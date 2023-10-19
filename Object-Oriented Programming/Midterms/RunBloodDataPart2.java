import java.util.Scanner;

public class RunBloodDataPart2 {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        BloodData bd1 = createBloodData();
        display(bd1);
        System.out.println(); // for spacing and a cleaner outputs
        BloodData bd2 = createBloodData();
        display(bd2);
    }

    private static BloodData createBloodData() {
        BloodData bloodData = new BloodData();
        bloodData.setBloodType(input("Enter blood type of patient: "));
        bloodData.setRhFactorType(input("Enter the Rhesus factor (+ or -): "));
        return bloodData;
    }

    private static String input(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    private static void display(BloodData bd) {
        System.out.printf(
                "%s%s is added to the blood bank\n",
                bd.getBloodType(), bd.getRhFactor());
    }
}

class BloodData {
    private String bloodType;
    private String rhFactor;

    public BloodData() {
        this.bloodType = "O"; // default blood type
        this.rhFactor = "+"; // default rh factor
    }

    public String getBloodType() {
        return this.bloodType;
    }

    public void setBloodType(String bt) {
        // If an invalid blood type is inputted, the default value will be set
        bt = bt.toUpperCase();
        if (!bt.equals("O") && !bt.equals("A") && !bt.equals("B") && !bt.equals("AB")) {
            bloodType = "O";
        } else {
            this.bloodType = bt;
        }
    }

    public String getRhFactor() {
        return this.rhFactor;
    }

    public void setRhFactorType(String rh) {
        // If an invalid rh factor is the argument, the default value will be set
        this.rhFactor = !rh.equals("+") && !rh.equals("-") ? "+" : rh;
    }
}