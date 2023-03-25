import java.util.Scanner;

public class App {
    private static final Scanner input = new Scanner(System.in);
    private static String chosenName;

    public static void main(String[] args) {
        chosenName = userInput("Employee Name");

        String choice;
        do {
            System.out.println("Select your option:\n[P] Part-time Employee\n[F] Full-time Employee");
            choice = userInput("Choice");
        } while (!choice.equalsIgnoreCase("P") && !choice.equalsIgnoreCase("F"));

        if (choice.equalsIgnoreCase("P")) {
            createPartTimeEmployee();
        } else if (choice.equalsIgnoreCase("F")) {
            createFullTimeEmployee();
        }

        System.out.println();
    }

    private static void createPartTimeEmployee() {
        PartTimeEmployee employee = new PartTimeEmployee();
        employee.setName(chosenName);
        employee.setRatePerHour(userInputDouble("Employee Rate Per Hour"));
        employee.setHoursWorked(userInputInt("Employee Hours Worked"));
        employee.setWage(employee.getRatePerHour() * employee.getHoursWorked());
        displayPartTimeEmployee(employee);
    }

    private static void createFullTimeEmployee() {
        FullTimeEmployee employee = new FullTimeEmployee();
        employee.setName(chosenName);
        employee.setMonthlySalary(userInputInt("Employee Monthly Salary"));
        displayFullTimeEmployee(employee);
    }

    private static void displayPartTimeEmployee(PartTimeEmployee employee) {
        displayLine();
        String name = employee.getName();
        System.out.printf("%s's Employee Information\n", employee.getName());
        System.out.printf("%s's Rate Per Hour: %s\n", name, employee.getRatePerHour());
        System.out.printf("%s's Hours Worked: %s\n", name, employee.getHoursWorked());
        System.out.printf("%s's Wage: %s\n", name, employee.getWage());
    }

    private static void displayFullTimeEmployee(FullTimeEmployee employee) {
        displayLine();
        System.out.printf("%s's Employee Information\n", employee.getName());
        System.out.printf("%s's Monthly Salary: %s",
                employee.getName(), employee.getMonthlySalary());
    }

    private static void displayLine() {
        String line = "\n---------------------------\n";
        System.out.printf("%s :----------------------:  %s\n", line, line);
    }

    private static double userInputDouble(String prompt) {
        try {
            return Double.parseDouble(userInput(prompt));
        } catch (Exception error) {
            System.out.println("Input must be a double!");
            return userInputDouble(prompt);
        }
    }

    private static int userInputInt(String prompt) {
        try {
            return Integer.parseInt(userInput(prompt));
        } catch (Exception error) {
            System.out.println("Input must be an integer!");
            return userInputInt(prompt);
        }
    }

    private static String userInput(String prompt) {
        System.out.printf("%s: ", prompt);
        return input.nextLine();
    }
}
