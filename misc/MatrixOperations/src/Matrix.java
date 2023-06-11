import java.util.*;

public class Matrix {
    private int[][] matrix;

    public Matrix(int rows, int columns) throws Exception {
        if (rows <= 0 && columns <= 0) {
            throw new Exception("Invalid argument!");
        }
        this.matrix = new int[rows][columns];
    }

    public void display() {
        for (int i = 0; i < this.matrix.length; i++) {
            String.join(' ', this.matrix[i]);
            
        }
    }
}
