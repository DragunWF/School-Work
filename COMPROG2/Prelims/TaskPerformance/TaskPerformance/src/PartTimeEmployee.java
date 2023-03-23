public class PartTimeEmployee extends Employee {
    private double ratePerHour;
    private int hoursWorked;
    private double wage;

    public void setRatePerHour(double value) {
        this.ratePerHour = value;
    }

    public void setHoursWorked(int value) {
        this.hoursWorked = value;
    }

    public void setWage(double value) {
        this.wage = value;
    }

    public double getRatePerHour() {
        return this.ratePerHour;
    }

    public int getHoursWorked() {
        return this.hoursWorked;
    }

    public double getWage() {
        return this.wage;
    }
}
