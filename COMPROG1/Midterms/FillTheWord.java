import java.util.*;

public class FillTheWord {
    private static Scanner input = new Scanner(System.in); 
    private static String previousChosenWord = "";

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

        input.close();
    }

    private static String playerInput(String prompt) {
        System.out.println(prompt);
        return input.nextLine();
    }

    private static HashMap<Character, Integer> mapLetters(char[] letters) {
        HashMap<Character, Integer> letterCount = new HashMap<Character, Integer>();
        for (int i = 0; i < letters.length; i++) {
            if (!letterCount.containsKey(letters[i])) {
                letterCount.put(letters[i], 1);
            } else {
                final int updatedValue = letterCount.get(letters[i]) + 1;
                letterCount.put(letters[i], updatedValue);
            }
        }
        return letterCount;
    }

    private static int countLetter(char[] wordArr, char letter) {
        int count = 0;
        for (char element : wordArr)
            if (element == letter)
                count++;
        return count;
    }

    private static int getRandomIndex(int arrayLength) {
        return (int) Math.floor(Math.random() * arrayLength);
    }

    private static String chooseRandomWord() {
        String[] words = { 
            "dragon", "castle", "sword", "keyboard", 
            "vampire", "whiterun", "diamond", "destruction",
            "macbook", "starbucks", "magic", "wizards" 
        };
        int chosenIndex = getRandomIndex(words.length);
        while (words[chosenIndex].equals(previousChosenWord))
            chosenIndex = getRandomIndex(words.length);
        previousChosenWord = words[chosenIndex];
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

    private static void playGame() {
        final int maxTries = 3; // code readability
        byte tries = 0;

        String correctWord = chooseRandomWord();
        String playerWord = randomizeWord(correctWord);
        char[] correctWordArr = correctWord.toCharArray();
        HashMap<Character, Integer> correctLetterCount = mapLetters(correctWordArr);
        System.out.println("Complete the word!\n" + playerWord);

        while (tries < maxTries) {
            System.out.println(maxTries - tries + " trials left");
            char c = input.nextLine().toLowerCase().charAt(0);
            char[] playerArr = playerWord.toCharArray();

            boolean hasLetter = false;
            for (int i = 0; i < playerArr.length; i++) {
                int letterCount = countLetter(playerArr, c);
                if (correctWordArr[i] == c && 
                    correctLetterCount.get(c) != null &&
                    letterCount < correctLetterCount.get(c)
                ) {
                    playerArr[i] = c;
                    correctWordArr[i] = '_';
                    correctLetterCount.put(c, correctLetterCount.get(c) + 1);
                    hasLetter = true;
                }
            }

            if (!hasLetter) {
                tries++;
                System.out.println(tries < maxTries ? 
                    "Try again!" : String.format("Correct word was: %s", correctWord)
                );
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