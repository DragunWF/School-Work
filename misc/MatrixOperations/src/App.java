import Scripts.Matrix;
import Scripts.ResultMatrix;

public class App {
    public static void main(String[] args) throws Exception {
        Matrix a = new Matrix(2, 3);
        Matrix b = new Matrix(3, 2);

        System.out.println();
        show(a, "a");
        show(b, "b");

        show(a.add(b), "a + b");
        show(a.subtract(b), "a - b");
        show(a.multiply(b), "a * b");
        show(a.transpose(), "a^t");

        ResultMatrix c = a.transpose();
        show(c.subtract(b), "c (a^t - b)");
    }

    private static void show(Matrix matrix, String varName) {
        System.out.printf("Matrix %s:\n", varName);
        if (matrix != null) {
            matrix.display();
        } else {
            System.out.println("undefined");
        }
        System.out.println();
    }
}
