import java.util.Scanner;

public class RunAmountDue {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = choose();
        double[] values = new double[3];
        AmountDue due = new AmountDue();
        double amount = 0;
        for (int i = 0; i < choice; i++) {
            values[i] = sc.nextDouble();
        }
        switch (choice) {
            case 1 -> amount = due.computeAmountDue(values[0]);
            case 2 -> amount = due.computeAmountDue(values[0], values[1]);
            case 3 -> amount = due.computeAmountDue(values[0], values[1], values[2]);
        }
        System.out.printf("Amount due is %s\n", amount);
    }

    private static int choose() {
        System.out.println("Press any of the following then enter values separated by spaces:");
        System.out.println("1 - Price Only\n2 - Price and quantity\n3 - Price, quantity, and discount amount");
        return sc.nextInt();
    }
}

class AmountDue {
    public double computeAmountDue(double price) {
        return price + price * 0.12;
    }

    public double computeAmountDue(double price, double quantity) {
        return price * quantity + price * 0.12;
    }

    public double computeAmountDue(double price, double quantity, double discount) {
        return (price * quantity - discount) + price * 0.12;
    }
}