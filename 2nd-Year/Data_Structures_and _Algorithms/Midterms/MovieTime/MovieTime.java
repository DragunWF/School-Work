import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class MovieTime {
    private static final Scanner sc = new Scanner(System.in);
    private static Queue<String> movies = new LinkedList<String>();
    private static Queue<String> snacks = new LinkedList<String>();

    public static void main(String[] args) throws Exception {
        final int MOVIE_COUNT = 3, SNACK_COUNT = 3;
        fillQueue(MOVIE_COUNT, false);
        fillQueue(SNACK_COUNT, true);
        displayQueue(false);
        displayQueue(true);
        while (!snacks.isEmpty()) {
            String userOption = input("Press S each time you finish a snack.\n");
            if (userOption.equalsIgnoreCase("S")) {
                snacks.poll();
            }
            System.out.println(snacks);
        }
        System.out.println("No more snacks");
    }

    private static void fillQueue(int count, boolean isSnack) throws Exception {
        String type = isSnack ? "snack" : "movie";
        for (int i = 1; i <= count; i++) {
            String userValue = input(String.format("Enter %s %s of %s: ", type, i, count));
            if (isSnack) {
                snacks.offer(userValue);
            } else {
                movies.offer(userValue);
            }
        }
    }

    private static void displayQueue(boolean isSnack) {
        if (!isSnack) {
            System.out.println("Movies to watch are " + movies);
        } else {
            System.out.println("Snacks available are " + snacks);
        }
    }

    private static String input(String prompt) throws Exception {
        try {
            System.out.print(prompt);
            return sc.nextLine();
        } catch (Exception error) {
            System.out.println("Invalid input! Please try again...");
            return input(prompt);
        }
    }
}