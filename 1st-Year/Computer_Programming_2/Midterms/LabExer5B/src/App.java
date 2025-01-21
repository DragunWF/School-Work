import java.util.*;

public class App {
    private static final Scanner sc = new Scanner(System.in);
    private static final Question[] questions = new Question[10];
    private static int score = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to Quiz Bee!\n");
        fillQuestions();
        askQuestions();
        System.out.printf("Thanks for playing, your score is %s/%s!\n",
                score, questions.length);
    }

    private static void askQuestions() {
        for (int i = 0; i < questions.length; i++) {
            System.out.printf("%s. %s\n", i + 1, questions[i].getQuestion());
            questions[i].displayChoices();

            String playerAnswer = userAnswer().toUpperCase();
            if (playerAnswer.equals(questions[i].getAnswer())) {
                score++;
                System.out.println("Correct!\n");
            } else {
                System.out.printf("Wrong! Correct answer was %s\n\n",
                        questions[i].getChoices().get(questions[i].getAnswer()));
            }
        }
    }

    private static void fillQuestions() {
        questions[0] = new Question("Which Country contains the great pyramids?",
                createChoices("Egypt", "Morocco", "England"), "A");
        questions[1] = new Question("Which company is responsible for macOS?",
                createChoices("Microsoft", "Oracle", "Apple"), "C");
        questions[2] = new Question("Which company made the Windows OS",
                createChoices("Apple", "Microsoft", "Oracle"), "B");
        questions[3] = new Question("Which company is responsible for the Java programming language?",
                createChoices("Apple", "Microsoft", "Oracle"), "C");
        questions[4] = new Question("Who is the main developer of Linux?",
                createChoices("Linus Torvalds", "Richard Stallman", "Bill Gates"), "A");
        questions[5] = new Question("Who is the current CEO of Apple?",
                createChoices("Bill Gates", "Tim Cook", "Steve Jobs"), "B");
        questions[6] = new Question("What programming language started it all?",
                createChoices("C++", "Java", "C Language"), "C");
        questions[7] = new Question("Which programming language is TypeScript derived from?",
                createChoices("JavaScript", "Java", "C#"), "A");
        questions[8] = new Question("Which country is Silicon Valley from?",
                createChoices("Germany", "Canada", "United States"), "C");
        questions[9] = new Question("Which language is used to style a web page?",
                createChoices("JavaScript", "CSS", "HTML"), "B");
    }

    private static HashMap<String, String> createChoices(String a, String b, String c) {
        final HashMap<String, String> output = new HashMap<>();
        output.put("A", String.format("A: %s", a));
        output.put("B", String.format("B: %s", b));
        output.put("C", String.format("C: %s", c));
        return output;
    }

    private static String userAnswer() {
        final String[] validChoices = { "A", "B", "C" };
        try {
            System.out.print("Your choice: ");
            String answer = sc.nextLine().toUpperCase();
            for (String choice : validChoices) {
                if (answer.equals(choice)) {
                    return answer;
                }
            }
            throw new Exception();
        } catch (Exception err) {
            System.out.println("Invalid Choice!");
            return userAnswer();
        }
    }
}
