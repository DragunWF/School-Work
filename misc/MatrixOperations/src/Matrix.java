import java.util.*;

public class Matrix {
    private int[][] matrix;

    public Matrix(int rows, int columns) throws Exception {
        if (rows <= 0 && columns <= 0) {
            throw new Exception("Invalid arguments!");
        }
        this.matrix = new int[rows][columns];
        generateMatrix();
    }

    public int get(int rowIndex, int columnIndex) {
        return matrix[rowIndex][columnIndex];
    }



    public void display() {
        for (int i = 0; i < this.matrix.length; i++) {
            String nums = String.join(" ", Utils.stringify(this.matrix[i]));
            System.out.printf("[%s]\n", nums);
        }
    }

    private void generateMatrix() {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                this.matrix[i][j] = Utils.randomRange(-50, 50);
            }
        }
    }
}
