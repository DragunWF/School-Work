import java.util.*;

public class Payroll {
    private static final Scanner input = new Scanner(System.in);
    private static HashMap<String, String> info = new HashMap<String, String>();
    private static final String[] prompts = {
            "Name", "Age", "Position", "Salary",
            "Pag-ibig", "Philhealth", "SSS #1", "SSS #2"
    };
    private static final int[] intItemIndexes = { 3, 4, 5, 6, 7 };
    private static final int ageIndex = 1;

    public static void main(String[] args) {
        for (int i = 0; i < prompts.length; i++) {
            while (true) {
                String userStr = userInput(prompts[i]);
                if (i == ageIndex && checkForDigits(userStr)) {
                    final int age = Integer.parseInt(userStr);
                    if (age >= 1 && age <= 120) { // age validation
                        info.put(prompts[i], String.valueOf(userStr));
                        break;
                    }
                } else if (checkIntIndex(i) && checkForDigits(userStr)) {
                    info.put(prompts[i], userStr);
                    break;
                } else if (!checkIntIndex(i)) {
                    info.put(prompts[i], userStr);
                    break;
                }
                System.out.println("Invalid Input! Try again...");
            }
        }

        computeMiscInfo();
        displayOutput();
    }

    private static void displayOutput() {
        System.out.println("\nOutput:");

        final String[] orderOfKeys = {
                "Name", "Age", "Position", "Salary",
                "Pag-ibig", "Philhealth", "SSS", "Tax",
                "Total Salary"
        };
        for (String key : orderOfKeys) {
            final String value = info.get(key);
            System.out.printf("%s: %s\n", key, value);
        }
    }

    private static void computeMiscInfo() {
        final int sss = Math.abs(Integer.parseInt(info.get("SSS #1")) -
                Integer.parseInt(info.get("SSS #2")));
        final int tax = (sss + Integer.parseInt(info.get("Philhealth")) +
                Integer.parseInt(info.get("Pag-ibig")));
        final int totalSalary = Integer.parseInt(info.get("Salary")) - tax;

        info.put("SSS", String.valueOf(sss));
        info.put("Tax", String.valueOf(tax));
        info.put("Total Salary", String.valueOf(totalSalary));

        info.remove("SSS #1");
        info.remove("SSS #2");
    }

    private static boolean checkIntIndex(int index) {
        for (int intIndex : intItemIndexes) {
            if (index == intIndex) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkForDigits(String userInfo) {
        char[] digits = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
        char[] charInfo = userInfo.toCharArray();

        for (char item : charInfo) {
            boolean foundDigit = false;
            for (char digit : digits) {
                if (item == digit) {
                    foundDigit = true;
                    break;
                }
            }
            if (!foundDigit) {
                return false;
            }
        }
        return true;
    }

    private static String userInput(String prompt) {
        System.out.printf("%s: ", prompt);
        return input.nextLine();
    }
}
