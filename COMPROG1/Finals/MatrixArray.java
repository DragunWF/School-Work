public class MatrixArray {
    private static int[][] matrix = new int[9][9];
    private static char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) {
        System.out.println();
        randomizeMatrix();
        displayAlphabets();
        displayMatrix();
        System.out.println();
    }

    private static void randomizeMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int random = (int) Math.floor(Math.random() * 10);
                matrix[i][j] = random;
            }
        }
    }

    private static void displayAlphabets() {
        System.out.print("    ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("%s ", alphabets[i]);
        }
        System.out.println();
    }

    private static void displayMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("%s | ", i + 1);
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("%s ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
