import java.util.*;

public class App {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Matrix a = new Matrix(2, 3);
        Matrix b = new Matrix(2, 3);

        System.out.println();
        show(a, "a");
        show(b, "b");

        show(a.add(b), "r");
        show(a.transpose(), "a^t");
    }

    private static void show(Matrix matrix, String varName) {
        if (matrix != null) {
            matrix.display(varName);
        } else {
            System.out.println("undefined");
        }
        System.out.println();
    }
}
