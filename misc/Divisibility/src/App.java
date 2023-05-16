import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        new DivisibilityGame(Utils.chooseAmount()).play();
    }
}

class DivisibilityGame {
    private ArrayList<Integer> chosenNumbers = new ArrayList<>();
    private int[] range = { 25, 5000 };
    private int[] divisorRange = { 2, 12 };

    private int numbersToSolve;
    private String[] table;

    public DivisibilityGame(int numbers) {
        this.numbersToSolve = numbers;
        this.table = new String[numbers];
        for (int i = 0; i < this.numbersToSolve; i++) {
            int randomNum = this.getRandomInt(this.range[0], this.range[1]);
            if (!chosenNumbers.contains(randomNum)) {
                chosenNumbers.add(randomNum);
            }
        }
    }

    private int getRandomInt(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min) + min);
    }

    private void generateTable() {
        this.table[0] = generateHeader();
        for (int i = 1; i < numbersToSolve; i++) {
            this.table[i] = generateRow(i);
        }
    }

    private String generateRow(int index) {
        int number = this.chosenNumbers.get(index);
        String[] output = new String[this.divisorRange[1] - this.divisorRange[0] + 1];
        for (int i = 0; i < output.length; i++) {
            int divisor = this.divisorRange[0] + i;
            output[i] = String.format("%s", number % divisor == 0 ? "Y" : "N");
        }
        return String.join(" | ", output);
    }

    private String generateHeader() {
        String[] output = new String[this.numbersToSolve];
        String firstCell = " ";
        for (int i = 0, n = String.valueOf(this.range[1]).length(); i < n; i++) {
            firstCell += " ";
        }
        output[0] = firstCell;
        for (int i = 1; i < output.length; i++) {
            output[i] = String.valueOf(this.divisorRange[0] + (i - 1));
        }
        return String.join(" | ", output);
    }

    private void printTable() {
        for (String row : this.table) {
            System.out.println(row);
        }
    }

    public void play() {
        System.out.println("Enter anything to show answers ");
        Utils.voidInput();
        generateTable();
        printTable();
    }
}

class Utils {
    private static Scanner sc = new Scanner(System.in);

    public static int chooseAmount() {
        System.out.print("Input the amount of numbers you want to solve with divisibility: ");
        int output;
        try {
            output = sc.nextInt();
        } catch (NumberFormatException err) {
            return chooseAmount();
        }
        return output;
    }

    public static void voidInput() {
        sc.next();
    }
}
