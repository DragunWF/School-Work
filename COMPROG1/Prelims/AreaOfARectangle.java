import java.util.Scanner;

public class AreaOfARectangle {
    public static void main(String[] args) {
        int width = enterValue("Enter width");
        int height = enterValue("Enter height");
        int area = width * height;
        System.out.println("Area of the rectangle: " + area);
    }

    private static int enterValue(String prompt) {
        System.out.println(prompt + ":");
        return new Scanner(System.in).nextInt();
    }
}
