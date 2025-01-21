import java.util.*;

public class Pattern {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        final int height = userInput("Enter pattern height:");
        final int width = userInput("Enter pattern width:");
        generatePattern(height, width);
    }

    private static void generatePattern(int height, int width) {
        boolean rightSnake = true;
        
        for (int i = 1; i <= height; i++) {
            String line = "";
            boolean evenIteration = i % 2 == 0;

            for (int j = 1; j <= width; j++) {
                if (evenIteration && rightSnake)
                    line += j == width ? "x" : ".";
                else if (evenIteration && !rightSnake)
                    line += j == 1 ? "x" : ".";
                else
                    line += "x";
            }

            if (evenIteration)
                rightSnake = rightSnake ? false : true;
            System.out.println(line);
        }
    }

    private static int userInput(String prompt) {
        System.out.println(prompt);
        return input.nextInt();
    }
}
