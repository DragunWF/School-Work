/*
  * Instructions:
  * 1. Create a constructor named Exam that assigns "Good luck" to a previously declared String variable named message.
  * 2. Create an empty overloaded constructor for the Exam class with two (2) String parameters named period and level.
  * 3. Declare a double-type accessor named getPrice that returns the value of price.
  * 4. Declare a boolean-type accessor named isFinished that returns the value of status.
  * 5. Declare a class named Midterm that inherits from the class named Exam.
  * 6. Create three (3) class declarations to show multiple levels of inheritance. Use the classes named Exam, Midterm, and Essay.
  * 7. Create a constructor named Midterm that prints "Exam has started." using println(). Its first statement should be a call to a constructor in the parent class.
  * 8. Given the base class named Quiz and the derived class named Essay, write a statement to show inheritance between these classes. 
*/

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
        System.out.println("Inheritance between classes:");
        System.out.printf("\"sub%s\" inherits from \"super %s\"\n", m.getClass(),
                m.getClass().getSuperclass());

        Essay e = new Essay();
        System.out.printf("\"derived %s\" inherits from \"base %s\"\n", e.getClass(),
                e.getClass().getSuperclass());
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
