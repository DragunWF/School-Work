import java.util.Scanner;

public class RunQuad {
    private static Scanner sc = new Scanner(System.in);
    private static String[] shapes = { "R - Rectangle", "S - Square",
            "P - Parallelogram", "H - Rhombus", "T - Trapezoid" };

    public static void main(String[] args) {
        System.out.println("Select from the following:");
        for (String option : shapes) {
            System.out.println(option);
        }
        Quadrilateral shape = chooseShape();
        System.out.printf("A %s:\n", shape.getClass().getName());
        shape.showDescription();
    }

    private static Quadrilateral chooseShape() {
        String userInput = sc.next().toUpperCase();
        switch (userInput) {
            case "R":
                return new Rectangle();
            case "S":
                return new Square();
            case "P":
                return new Parellelogram();
            case "H":
                return new Rhombus();
            case "T":
                return new Trapezoid();
            default:
                System.out.println("Invalid option! Please choose a valid option from the given above!");
                return chooseShape();
        }
    }
}

class Quadrilateral {
    public void showDescription() {
        System.out.println("- is quadrilateral");
    }
}

class Rectangle extends Quadrilateral {
    public void showDescription() {
        System.out.println("- has 4 right angles");
        super.showDescription();
    }
}

class Square extends Rectangle {
    public void showDescription() {
        System.out.println("- has 4 equal sides");
        super.showDescription();
    }
}

class Parellelogram extends Quadrilateral {
    public void showDescription() {
        System.out.println("- has 2 pairs of parallel sides");
        super.showDescription();
    }
}

class Rhombus extends Parellelogram {
    public void showDescription() {
        System.out.println("- has 4 congruent sides");
        super.showDescription();
    }
}

class Trapezoid extends Quadrilateral {
    public void showDescription() {
        System.out.println("- has 1 pair of parallel sides");
        super.showDescription();
    }
}
