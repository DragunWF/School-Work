public class FoilAndQuadratic {
    public static void main(String[] args) { 
        final String wall = "----------------------------------";
        System.out.println(wall);

        System.out.println("First problem: (Foil Method)");
        solveFirst();

        System.out.println();

        System.out.println("Second problem: (Foil Method");
        solveSecond();

        System.out.println(wall);

        System.out.println("Third problem: (Quadratic Equation)");
        solveThird();

        System.out.println();

        System.out.println("Fourth problem: (Quadratic Equation)");
        solveFourth();

        System.out.println(wall);
    }

    private static void printAnswer(String ans) {
        System.out.println(String.format("Answer: %s", ans));
    }

    private static void solveFirst() {
        System.out.println("Solve: (5n + 3)(n + 6)");
        final int a, b, c, d;
        a = 5; b = 3; c = 4; d = 6;
        final int x = b * d + (c - c);
        final int y = a * d + b;
        printAnswer(String.format("%sn^2 + %sn + %s", a, y, x));
    }

    private static void solveSecond() {
        System.out.println("Solve: (x + 1)(2x - 3)");
        final int a, b, c, d;
        a = 1; b = 1; c = 2; d = -3;
        final int x = a * c;
        final int y = Math.abs(b * d); // Abs just for the output and display
        printAnswer(String.format("%sx^2 - x - %s", x, y));
    }

    private static void solveThird() {
        System.out.println("Solve: 2x^2 + x - 300 = 0");
        final int a, b, c;
        a = 2; b = 1; c = -300;
        final double x = Math.sqrt(b * b - 4 * (2 * c));
        final double y = (-b + x) / (a * a);
        final double z = (-b - x) / (a * a);
        printAnswer(String.format("x = %s, x = %s", (int)y, z));
    
    }

    private static void solveFourth() {
        System.out.println("Solve: x^2 + 4x - 5 = 0");
        final double a, b, c;
        a = 1; b = 4; c = -5;
        final double x = Math.sqrt(4 * 4 - 4 * a * c);
        final double y = (-b + x) / (2 * c);
        final double z = (-b - x) / (2 * c);
        printAnswer(String.format("x = %s, x = %s", (int)y, (int)z));
    }
}
