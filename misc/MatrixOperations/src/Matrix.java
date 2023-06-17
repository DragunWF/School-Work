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

    public int[][] add(Matrix otherMatrix) {
        return operateMatrix(otherMatrix, true);
    }

    public int[][] subtract(Matrix otherMatrix) {
        return operateMatrix(otherMatrix, false);
    }

    public int[][] multiply(Matrix otherMatrix) {
        // TODO: implement matrix multiplication
        return null;
    }

    public void display(String matrixVarName) {
        System.out.printf("Matrix %s:\n", matrixVarName);
        for (int i = 0; i < this.matrix.length; i++) {
            String nums = String.join(" ", Utils.stringify(this.matrix[i]));
            System.out.printf("[%s]\n", nums);
        }
    }

    public void mutateEntry(int rowIndex, int columnIndex, int value) {
        this.matrix[rowIndex][columnIndex] = value;
    }

    public int[][] scalarMultiplication(int wholeNum) {
        int[][] output = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[0].length; j++) {
                output[i][j] = wholeNum * matrix[i][j];
            }
        }
        return output;
    }

    private int[][] operateMatrix(Matrix otherMatrix, boolean isAddition) {
        int[][] output = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (isAddition) {
                    output[i][j] = get(i, j) + otherMatrix.get(i, j);
                    continue;
                }
                output[i][j] = get(i, j) - otherMatrix.get(i, j);
            }
        }
        return output;
    }

    private void generateMatrix() {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                this.matrix[i][j] = Utils.randomRange(-50, 50);
            }
        }
    }
}
