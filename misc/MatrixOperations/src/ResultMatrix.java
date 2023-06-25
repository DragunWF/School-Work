public class ResultMatrix extends Matrix {
    public ResultMatrix(int rows, int columns, int[][] result) throws Exception {
        super(rows, columns);
        this.matrix = result;
    }
}
