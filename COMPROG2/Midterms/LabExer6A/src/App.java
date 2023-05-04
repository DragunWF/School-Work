import java.util.*;
import java.io.*;

public class App {
    private static final String path = "/Users/marcplarisan/Documents/DevStuff/Repositories/School-Work/COMPROG2/Midterms/LabExer6A/src/words.txt";
    private static final Scanner input = new Scanner(System.in);
    private static int attempts = 5;

    public static void main(String[] args) throws Exception {
        String correctWord = getRandomWord();
        String displayedWord = replaceVowels(correctWord);
        while (!displayedWord.equals(correctWord) && attempts > 0) {
            System.out.printf("Guess the word: %s\n", displayedWord);
            String answer = String.valueOf(userInput("Your answer").charAt(0)).toLowerCase();
            if (checkAnswer(correctWord, answer)) {
                displayedWord = updateWord(correctWord, displayedWord, answer);
            } else {
                attempts--;
                System.out.printf("Wrong!\nAttempts: %s\n", attempts);
            }
        }
        System.out.println(attempts > 0 ? "Congrats you guessed it!" : "You failed!");
    }

    private static String updateWord(String fullWord, String currentWord, String answer) {
        String output = "";
        for (int i = 0, n = fullWord.length(); i < n; i++) {
            if (currentWord.charAt(i) == '?') {
                output += fullWord.charAt(i) == answer.charAt(0) ? answer : '?';
            } else {
                output += currentWord.charAt(i);
            }
        }
        return output;
    }

    private static String getRandomWord() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        ArrayList<String> words = new ArrayList<>();
        String word = br.readLine();
        while (word != null) {
            words.add(word);
            word = br.readLine();
        }
        br.close();
        return words.get((int) Math.floor(Math.random() * words.size()));
    }

    private static String replaceVowels(String word) {
        final String vowels = "aeiou";
        String output = "";
        for (int i = 0, n = word.length(); i < n; i++) {
            String letter = String.valueOf(word.charAt(i));
            output += vowels.indexOf(letter) != -1 ? "?" : letter;
        }
        return output;
    }

    private static String userInput(String prompt) {
        System.out.printf("%s: ", prompt);
        return input.nextLine();
    }

    private static boolean checkAnswer(String fullWord, String answer) {
        return fullWord.indexOf(answer) != -1;
    }
}
