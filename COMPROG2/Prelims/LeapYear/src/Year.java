public class Year {
    protected int number;

    public boolean isLeapYear() {
        return (this.number % 4 == 0 && this.number % 100 != 0) || this.number % 400 == 0;
    }
}
