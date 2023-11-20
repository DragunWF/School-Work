import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class StudentList {
    private static final Scanner sc = new Scanner(System.in);
    private static Map<String, String> students = new HashMap<>();

    public static void main(String[] args) {
        String thirdEntryKey = null;
        for (int i = 1, classmates = 3; i <= classmates; i++) {
            String key = input(String.format("Enter student number %s: ", i));
            students.put(key, input(String.format("Enter first name %s: ", i)));
            if (i == 3) {
                thirdEntryKey = key;
            }
        }

        printStudentList(students);
        students.remove(thirdEntryKey);
        students.put(input("Enter your student number: "), input("Enter your first name: "));
        printStudentList(students);
    }

    private static void printStudentList(Map<String, String> students) {
        System.out.println("Student List:");
        for (String key : students.keySet()) {
            System.out.printf("%s %s\n", key, students.get(key));
        }
    }

    private static String input(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }
}