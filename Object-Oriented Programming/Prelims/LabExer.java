import java.util.*;

public class RunSavingsAccount {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount();
        double interestRate = userInput("Enter interest rate: ");
        double depositAmount = userInput("Enter deposit amount: ");

        SavingsAccount.setInterestRate(interestRate);
        savings.deposit(depositAmount);
        SavingsAccount.showBalance(savings);

        System.out.print("Press D for another deposit or W to withdraw: ");
        String choice = sc.next();
        if (choice.equalsIgnoreCase("D")) {
            double secondDepositAmount = userInput("Enter deposit amount: ");
            savings.deposit(secondDepositAmount);
        } else {
            double withdrawAmount = userInput("Enter amount to withdraw: ");
            savings.withdraw(withdrawAmount);
        }

        if (savings.getBalance() > 1000) {
            savings.addInterest();
        }
        SavingsAccount.showBalance(savings);
    }

    private static double userInput(String prompt) {
        System.out.print(prompt);
        return sc.nextDouble();
    }
}

class SavingsAccount {
    private double balance;
    public static double interestRate;

    public SavingsAccount() {
        this.balance = 0;
    }

    public static void setInterestRate(double newRate) {
        interestRate = newRate;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
        } else {
            this.balance = 0;
        }
        return amount;
    }

    public void addInterest() {
        double interest = this.balance * this.interestRate;
        this.balance += interest;
    }

    public static void showBalance(SavingsAccount account) {
        System.out.printf("Your new balance is %s\n", account.getBalance());
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public double getBalance() {
        return this.balance;
    }
}