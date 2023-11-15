import java.util.Scanner;
import java.util.PriorityQueue;

public class Greeting {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        PriorityQueue<String> nicknames = new PriorityQueue<>();
        System.out.println("Enter the nickname of four of your classmates:");
        for (int i = 0, classmateCount = 4; i < classmateCount; i++) {
            nicknames.offer(sc.nextLine());
        }

        System.out.print("Press H to say Hi to each of them. ");
        do {
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("H")) {
                System.out.printf("Hi %s\n", nicknames.poll());
            }
        } while (!nicknames.isEmpty());

        String endChoice = sc.nextLine();
        while (!endChoice.equalsIgnoreCase("H")) {
            endChoice = sc.nextLine();
        }
        System.out.println("Done saying Hi");
    }
}