import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("Enter the limit:");
        int num = new Scanner(System.in).nextInt();
        generateFibonacci(num);
    }

    private static void generateFibonacci(int limit) {
        int[] seq = new int[limit];
        for (int i = 0; i < seq.length; i++)
            seq[i] = i <= 1 ? i : seq[i - 2] + seq[i - 1];
        
        System.out.println("Fibonacci Sequence:");
        for (int num : seq)
            System.out.print(num + " ");
    }
}
