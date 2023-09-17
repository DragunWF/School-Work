package Scripts;

public class ResultMatrix extends Matrix {
    public ResultMatrix(int[][] result) throws Exception {
        super(result.length, result[0].length);
        this.matrix = result;
    }
}
