import java.util.Scanner;

public class Project {
    private static final Scanner sc = new Scanner(System.in);
    private static final String[] roles = {
            "Student", "Visitor", "Teacher", "Administrator"
    };
    private static String userRole;

    public static void main(String[] args) {
        displayGroupMates();
        System.out.println("Welcome to the admissions system!");
        userRole = startUserSelection();
    }

    private static void displayGroupMates() {
        String groupMembers = { "Member A", "Member B", "Member C" };
        System.out.println("Chosen Information System: School");
        System.out.println("Group Members: ");
        for (int i = 0; i < groupMembers.length; i++) {
            System.out.printf("%s. %s\n", i + 1, groupMembers[i]);
        }
    }

    private static String startUserSelection() {
        System.out.println("Roles");
        for (String role : roles) {
            System.out.printf("- %s\n", role);
        }
        return chooseRole();
    }

    private static String chooseRole() {
        String chosenRole = Utils.input("What type of user are you?").toLowerCase();
        if (Utils.isContains(roles, chosenRole)) {
            return chosenRole;
        }
        System.out.println("That is not a valid role! Please choose from the selection...");
        return chooseRole();
    }
}

class Utils {
    public static String input(String prompt) {
        System.out.printf("%s ", prompt);
        return sc.nextLine();
    }

    public static boolean isContains(String[] array, String element) {
        for (String item : array) {
            if (item.equals(element)) {
                return true;
            }
        }
        return false;
    }
}

abstract class Staff {

}

class Teacher extends Staff {

}

class Administrator extends Staff {

}

class Student {

}

class Visitor {

}