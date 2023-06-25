public class Matrix {
    protected int[][] matrix;
    protected int rows;
    protected int columns;

    public Matrix(int rows, int columns) throws Exception {
        if (rows <= 0 && columns <= 0) {
            throw new Exception("Invalid arguments!");
        }
        this.matrix = new int[rows][columns];
        this.rows = rows;
        this.columns = columns;
        generateMatrix();
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public int get(int rowIndex, int columnIndex) {
        return matrix[rowIndex][columnIndex];
    }

    public int[] getRow(int rowIndex) {
        return this.matrix[rowIndex];
    }

    public ResultMatrix add(Matrix otherMatrix) throws Exception {
        return operateMatrix(otherMatrix, true);
    }

    public ResultMatrix subtract(Matrix otherMatrix) throws Exception {
        return operateMatrix(otherMatrix, false);
    }

    public ResultMatrix multiply(Matrix otherMatrix) throws Exception {
        if (this.columns != otherMatrix.getRows()) {
            return null;
        }

        int[][] output = new int[this.rows][otherMatrix.getColumns()];
        otherMatrix = otherMatrix.transpose();
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                output[i][j] = Utils.multiplyRowArray(this.matrix[i], otherMatrix.getRow(j));
            }
        }
        return new ResultMatrix(output);
    }

    public ResultMatrix transpose() throws Exception {
        int[][] output = new int[this.columns][this.rows];
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                output[i][j] = this.matrix[j][i];
            }
        }
        return new ResultMatrix(output);
    }

    public void display() {
        for (int i = 0; i < this.matrix.length; i++) {
            String nums = String.join(" ", Utils.stringify(this.matrix[i]));
            System.out.printf("[%s]\n", nums);
        }
    }

    public void mutateEntry(int rowIndex, int columnIndex, int value) {
        this.matrix[rowIndex][columnIndex] = value;
    }

    public ResultMatrix scalarMultiplication(int wholeNum) throws Exception {
        int[][] output = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                output[i][j] = wholeNum * matrix[i][j];
            }
        }
        return new ResultMatrix(output);
    }

    private ResultMatrix operateMatrix(Matrix otherMatrix, boolean isAddition) throws Exception {
        if (this.columns != otherMatrix.getColumns() || this.rows != otherMatrix.getRows()) {
            return null;
        }

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
        return new ResultMatrix(output);
    }

    private void generateMatrix() {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                this.matrix[i][j] = Utils.randomRange(-50, 50);
            }
        }
    }
}
