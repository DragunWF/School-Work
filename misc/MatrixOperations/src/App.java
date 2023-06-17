import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Matrix a = new Matrix(3, 3);
        Matrix b = new Matrix(3, 3);

        a.display("a");
        System.out.println();
        b.display("b");
        System.out.println();

        a.add(b);
        a.display("a + b");
    }
}
