import java.util.HashMap;

public class Question {
    private String question;
    private HashMap<String, String> choices;
    private String answer;

    public Question(String question, HashMap<String, String> choices, String answer) {
        this.question = question;
        this.choices = choices;
        this.answer = answer;
    }

    public String getQuestion() {
        return this.question;
    }

    public HashMap<String, String> getChoices() {
        return this.choices;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void displayChoices() {
        String[] availableChoices = { "A", "B", "C" };
        for (String choice : availableChoices) {
            System.out.println(this.choices.get(choice));
        }
    }
}
