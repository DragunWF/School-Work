public class MatrixArray {
    private static final int size = 9; // Adjust size here. It must not be greater than 25
    private static int[][] matrix = new int[size][size];
    private static char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) {
        System.out.println();
        randomizeMatrix();
        displayAlphabets();
        displayMatrix();
        System.out.println();
    }

    private static void randomizeMatrix() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int randomNum = (int) Math.floor(Math.random() * 10);
                matrix[i][j] = randomNum;
            }
        }
    }

    private static void displayAlphabets() {
        System.out.print("    ");
        for (int i = 0; i < size; i++) {
            System.out.printf("%s ", alphabets[i]);
        }
        System.out.println();
    }

    private static void displayMatrix() {
        for (int i = 0; i < size; i++) {
            System.out.printf("%s | ", i + 1);
            for (int j = 0; j < size; j++) {
                System.out.printf("%s ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
