import java.util.*;

public class FillTheLetter {
    public static void main(String[] args) {
        System.out.println("Welcome to the game!");
        int timesPlayed = 0;
        playGame();

        while (true) {
            timesPlayed++;
            String input = playerInput("Would you like to play again? (y/n)");
            if (input.equals("yes") || input.equals("y"))
                playGame();
            else
                break;
        }

        System.out.println("Thanks for playing!\n");
        String timeStr = timesPlayed > 1 ? "times" : "time";
        String message = String.format("You've played the game for %s %s",
                timesPlayed, timeStr);
        System.out.println(message);
    }

    private static String playerInput(String prompt) {
        System.out.println(prompt);
        return new Scanner(System.in).nextLine();
    }

    private static String chooseRandomWord() {
        String[] words = { 
            "dragon", "castle", "sword", "keyboard", 
            "vampire", "whiterun", "diamond", "destruction" 
        };
        int chosenIndex = (int) Math.floor(Math.random() * words.length);
        return words[chosenIndex];
    }

    private static String randomizeWord(String word) {
        String output = "";
        for (String letter : word.split("")) {
            int chance = (int) Math.floor(Math.random() * 3);
            output += chance == 0 ? letter : "_";
        }
        if (word.equals(output))
            return randomizeWord(word);
        return output;
    }

    private static String getRemaining(String original, String missing) {
        char[] output = new char[original.length()];
        char[] org = original.toCharArray();
        char[] input = missing.toCharArray();
        for (int i = 0; i < output.length; i++)
            output[i] = org[i] == input[i] ? org[i] : '_';
        return String.valueOf(output);
    }

    private static void playGame() {
        Scanner input = new Scanner(System.in);
        final int maxTries = 3; // code readability
        byte tries = 0;

        String correctWord = chooseRandomWord();
        String playerWord = randomizeWord(correctWord);
        char[] correctWordArr = correctWord.toCharArray();
        List<Character> chosenLetters = new ArrayList<Character>();
        System.out.println("Complete the word!\n" + playerWord);

        while (tries < maxTries) {
            System.out.println(maxTries - tries + " trials left");
            char c = input.nextLine().toLowerCase().charAt(0);
            char[] playerArr = playerWord.toCharArray();

            boolean hasLetter = false;
            for (int i = 0; i < playerArr.length; i++) {
                if (correctWordArr[i] == c && !chosenLetters.contains(c)) {
                    playerArr[i] = c;
                    correctWordArr[i] = '_';
                    chosenLetters.add(c);
                    hasLetter = true;
                }
            }

            if (!hasLetter) {
                tries++;
                System.out.println("Try again!");
            }

            String remaining = String.valueOf(playerArr);
            System.out.println(remaining);
            playerWord = remaining;

            if (remaining.equals(correctWord)) {
                System.out.println("Congrats, you won!");
                break;
            }
        }
    }
}