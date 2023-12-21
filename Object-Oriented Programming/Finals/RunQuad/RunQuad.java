import java.util.Scanner;

public class RunQuad {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Press R for Rectangle or S for Square: ");
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
                System.out.println("Invalid option! Choose either S or R!");
                return chooseShape();
        }
    }
}

class Quadrilateral {
    public void showDescription() {
        System.out.println("- us quadrilateral");
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
    }
}

class Rhombus extends Parellelogram {
    public void showDescription() {
        System.out.println("- has 4 congruent sides");
    }
}

class Trapezoid extends Quadrilateral {
    public void showDescription() {
        System.out.println("- has 1 pair of parallel sides");
    }
}
