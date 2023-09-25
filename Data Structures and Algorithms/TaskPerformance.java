import java.util.*;

public class TaskPerformance {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        NumberOne();
        System.out.println();
        NumberTwo();
    }

    private static void NumberOne() {
        // First letter of first name: M
        // Recursion Type: Binary Recursion
        /*
         * def fib(num):
         *    if num <= 1:
         *       return 1
         *    return fib(num - 1) + fib(num - 2)
         * 
         * num = int(input("Enter a number higher than 0: "))
         * for i in range(num):
         *    print(fib(i))
        */
        System.out.print("Enter a number higher than 0: ");
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            System.out.println(fib(i));
        }
    }

    private static int fib(int num) {
        if (num <= 1) {
            return num;
        }
        return fib(num - 1) + fib(num - 2);
    }

    private static void NumberTwo() {
        // First letter of last name: P
        // Values: Favorite movie/game characters
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("Luffy");
        linkedList.add("Zoro");
        linkedList.add("Nami");
        linkedList.add("Chopper");
        System.out.println("Favorite movie/game characters:");
        for (int i = 0, n = linkedList.size(); i < n; i++) {
            System.out.println(linkedList.get(i));
        }
    }
}
