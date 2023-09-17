import java.util.Scanner;

public class App {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Main program flow
        Human user = createHuman();
        introduceHuman(user);
    }

    private static Human createHuman() {
        // Creates a human profile
        int faveNumber = Integer.parseInt(userInput("Type your favorite number."));
        String faveCartoon = userInput("Type your favorite cartoon or anime character.");
        char mi = userInput("Type your middle initial").charAt(0);
        char[] nickName = userInput("Type your nickname").toCharArray();
        return new Human(faveNumber, faveCartoon, mi, nickName);
    }

    private static void introduceHuman(Human person) {
        // Introduces the person
        System.out.printf("%s is my favorite number!\n", person.getFaveNumber());
        System.out.printf("I love %s!\n", person.getFavoriteCartoon());
        System.out.printf("My name is Veronica %s. Velasquez\n", person.getMiddleInitial());
        System.out.printf("You can call me %s\n", person.getNickName());
    }

    private static String userInput(String prompt) {
        // For user inputs
        System.out.printf("%s ", prompt);
        return input.nextLine();
    }
}
