import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        new MathGame(Utils.chooseAmount()).play();
    }
}

class MathGame {
    private int[][] numPairs;
    private final int[] RANGE = { 10, 125 };

    public MathGame(int problems) {
        this.numPairs = new int[problems][2];
        for (int i = 0; i < problems; i++) {
            this.numPairs[i][0] = Utils.getRandomInt(RANGE[0], RANGE[1]);
            this.numPairs[i][1] = Utils.getRandomInt(RANGE[0], RANGE[1]);
        }
    }

    private int gcd(int num, int otherNum) {
        for (int i = Math.min(num, otherNum); i > 1; i--) {
            if (num % i == 0 && otherNum % i == 0) {
                return i;
            }
        }
        return 1;
    }

    private int lcm(int num, int otherNum) {
        ArrayList<Integer> multiples = new ArrayList<>();
        int multiplier = 1;
        while (true) {
            int multiple = num * multiplier;
            int otherMultiple = otherNum * multiplier;

            if (multiples.contains(multiple)) {
                return multiple;
            }
            if (multiples.contains(otherMultiple)) {
                return otherMultiple;
            }

            multiples.add(multiple);
            multiples.add(otherMultiple);
            multiplier++;
        }
    }

    private void printQuestions() {
        System.out.println("Get the GCD and LCM of the following numbers:\n");
        for (int i = 0; i < this.numPairs.length; i++) {
            int[] pair = this.numPairs[i];
            System.out.printf("%s.) %s, %s\n", i + 1, pair[0], pair[1]);
        }
        System.out.println();
    }

    private void printAnswers() {
        System.out.println();
        for (int i = 0; i < this.numPairs.length; i++) {
            int[] pair = this.numPairs[i];
            System.out.printf("%s.) gcd(%s, %s) = %s\n",
                    i + 1, pair[0], pair[1], gcd(pair[0], pair[1]));
            System.out.printf("    lcm(%s, %s) = %s\n",
                    pair[0], pair[1], lcm(pair[0], pair[1]));
        }
        System.out.println();
    }

    public void play() {
        printQuestions();
        System.out.print("Type in anything to reveal answers: ");
        Utils.voidInput();
        printAnswers();
    }
}

class Utils {
    private static final Scanner sc = new Scanner(System.in);

    public static int chooseAmount() {
        System.out.print("Select the amount of problems you want to solve: ");
        int output;
        try {
            output = sc.nextInt();
        } catch (NumberFormatException err) {
            return Utils.chooseAmount();
        }
        return output;
    }

    public static int getRandomInt(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min) + min);
    }

    public static void voidInput() {
        sc.next();
    }
}
