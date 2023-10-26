public class Exam {
    private String message;
    private double price;
    private boolean status;

    public Exam() {
        message = "Good Luck";
    }

    public Exam(String period, String level) {
    }

    public double getPrice() {
        return price;
    }

    public boolean isFinished() {
        return status;
    }

    public static void main(String[] args) {
        /*
         * This Method here is to address the instructions on number 6 and
         * number 8 about showing their inheritance via print statements and
         * other in-built methods within classes.
         */

        Midterm m = new Midterm();
        System.out.printf("Class %s inherits from main class %s\n", m.getClass(), m.getClass().getSuperclass());

        Essay e = new Essay();
        System.out.printf("Class %s inherits from class %s\n", e.getClass(), e.getClass().getSuperclass());
    }
}

class Midterm extends Exam {
    public Midterm() {
        super();
        System.out.println("Exam has started");
    }
}

class Quiz {
    // Base class Quiz
    // Check the main method for showing the inheritance between these classes
}

class Essay extends Quiz {
    // Class Essay inherits from base class Quiz
    // Check the main method for showing the inheritance between these classes
}
