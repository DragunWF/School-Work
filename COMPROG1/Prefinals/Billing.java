import java.util.*;

public class Billing {
    private static final Scanner input = new Scanner(System.in);
    private static HashMap<String, String> info = new HashMap<String, String>();
    private static String[] keys = {
            "Name", "Age", "Payment", "Amount"
    };

    public static void main(String[] args) {
        fillInfo();
        displayOutput();
    }

    private static void fillInfo() {
        for (String key : keys) {
            if (key.equals("Age")) {
                String value;
                int age;
                do {
                    value = userInput(key);
                    age = Integer.parseInt(value);
                } while (age <= 0 || age >= 120); // age validation
                info.put(key, value);
            } else if (key.equals("Payment")) {
                String form;
                do {
                    form = userInput("Payment (Cash/Credit)");
                } while (!form.equalsIgnoreCase("cash") && !form.equalsIgnoreCase("credit"));
                info.put(key, form);

                if (form.equalsIgnoreCase("credit")) {
                    String bank = userInput("Bank");
                    info.put("Bank", bank);
                }
            } else {
                String name = userInput(key);
                info.put(key, name);
            }
        }

        final double vat = 0.12;
        final double amount = Integer.parseInt(info.get("Amount"));
        info.put("Total Billing Payment", String.valueOf(amount * vat));
    }

    private static void displayOutput() {
        final String wall = "--------------------";
        String[] orderOfOutput = {
                "Name", "Age", "Payment", "Amount", "Total Billing Payment"
        };

        System.out.printf("\n%s\nBilling Program:\n", wall);
        for (String key : orderOfOutput) {
            String value = info.get(key);
            System.out.printf("%s: %s\n", key, value);

            if (key.equals("Payment") && info.get("Payment").equalsIgnoreCase("credit")) {
                String bank = info.get("Bank");
                System.out.printf("Bank: %s\n", bank);
            }
        }
        System.out.println(wall);
    }

    private static String userInput(String prompt) {
        System.out.printf("%s: ", prompt);
        return input.nextLine();
    }
}
