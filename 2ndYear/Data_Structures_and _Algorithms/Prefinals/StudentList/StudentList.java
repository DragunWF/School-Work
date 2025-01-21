import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class StudentList {
    private static final Scanner sc = new Scanner(System.in);
    private static Map<String, String> students = new HashMap<>();
    private static final int CLASSMATE_COUNT = 3;
    private static String[] orderOfKeys = new String[CLASSMATE_COUNT];

    public static void main(String[] args) {
        for (int i = 1; i <= CLASSMATE_COUNT; i++) {
            String key = input(String.format("Enter student number %s: ", i));
            students.put(key, input(String.format("Enter first name %s: ", i)));
            orderOfKeys[i - 1] = key;
        }

        printStudentList();
        students.remove(orderOfKeys[2]);
        String userStudentNum = input("Enter your student number: ");
        students.put(userStudentNum, input("Enter your first name: "));
        orderOfKeys[2] = userStudentNum;
        printStudentList();
    }

    private static void printStudentList() {
        System.out.println("Student List:");
        for (String key : orderOfKeys) {
            System.out.printf("%s %s\n", key, students.get(key));
        }
    }

    private static String input(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }
}