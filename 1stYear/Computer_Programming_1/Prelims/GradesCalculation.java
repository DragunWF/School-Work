import java.util.Scanner;

public class GradesCalculation {
    public static void main(String[] args) {
        String name = "Marc";
        System.out.println("Enter your grades:");

        int mathGrade = enterGrade("Math");
        int scienceGrade = enterGrade("Science");
        int englishGrade = enterGrade("English");
        int averageGrade = (mathGrade + scienceGrade + englishGrade) / 3;

        System.out.println(name + "'s average grade: " + averageGrade);
    }

    private static int enterGrade(String subjectName) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(subjectName + ":");
            int grade = scanner.nextInt();
            if (!(grade < 0 || grade > 100)) {
                scanner.close();
                return grade;
            }
            System.out.println("Grade must be within 0 to 100!");
        }
    }
}
