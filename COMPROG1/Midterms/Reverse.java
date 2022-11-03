import java.util.*;

public class Reverse {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        System.out.println("Enter 5 Numbers:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(String.format("Index %s: ", i));
            arr[i] = input.nextInt();
        }

        reverse(arr);
    }

    private static void reverse(int[] arr) {
        System.out.println("\nReversed:");
        for (int i = arr.length - 1; i >= 0; i--)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
