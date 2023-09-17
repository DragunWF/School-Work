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

    private int rowLength;
    private int numbersToSolve;
    private String[] table;

    public DivisibilityGame(int numbers) {
        this.numbersToSolve = numbers + 1; // Added one for header
        this.table = new String[this.numbersToSolve];
        for (int i = 0; i < this.numbersToSolve; i++) {
            int randomNum = this.getRandomInt(this.range[0], this.range[1]);
            if (!chosenNumbers.contains(randomNum)) {
                chosenNumbers.add(randomNum);
            }
        }
        this.rowLength = this.divisorRange[1] - this.divisorRange[0] + 2;
    }

    private int getRandomInt(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min) + min);
    }

    private String formatCellHeader(int number) {
        int whiteSpaces = Utils.digitsLen(this.range[1]) - Utils.digitsLen(number) + 1;
        String strNum = String.valueOf(number);
        for (int i = 0; i < whiteSpaces; i++) {
            strNum += " ";
        }
        return strNum;
    }

    private void generateTable() {
        this.table[0] = generateHeader();
        for (int i = 1; i < this.numbersToSolve; i++) {
            this.table[i] = generateRow(i);
        }
    }

    private String generateRow(int index) {
        int number = this.chosenNumbers.get(index);
        String[] output = new String[this.rowLength];
        output[0] = formatCellHeader(number);
        for (int i = this.divisorRange[0]; i <= this.divisorRange[1]; i++) {
            int outputIndex = i + 1 - this.divisorRange[0];
            output[outputIndex] = String.format("%s", number % i == 0 ? "Y" : "N");
            if (i >= 10) {
                output[outputIndex] += " ";
            }
        }
        return String.join(" | ", output);
    }

    private String generateHeader() {
        String[] output = new String[this.rowLength];
        String firstCell = " ";
        for (int i = 0, n = Utils.digitsLen(this.range[1]); i < n; i++) {
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

    private void printNumbers() {
        System.out.printf("Numbers: ");
        for (int i = 0, n = this.chosenNumbers.size() - 1; i < n; i++) {
            System.out.printf("%s ", this.chosenNumbers.get(i));
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public void play() {
        printNumbers();
        generateTable();
        System.out.print("Type in anything to show answers: ");
        Utils.voidInput();
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

    public static int digitsLen(int number) {
        return String.valueOf(number).length();
    }

    public static void voidInput() {
        sc.next();
    }
}
