import java.util.HashMap;
import java.io.*;

public class LoginAuthentication {
    private static final String path = "";
    private static final String alphanumeric = "abcdefghijklmnopqrstuvwxyz0123456789";

    public static void registerUser() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        HashMap<String, String> userInfo = getUserInfo();

        bw.write(String.format("%s\n", userInfo.get("username")));
        bw.write(String.format("%s", userInfo.get("password")));
        System.out.println("Successfully registered");

        bw.close();
    }

    public static void loginUser() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        HashMap<String, String> userInfo = getUserInfo();

        String storedUsername = br.readLine();
        String storedPassword = br.readLine();
        if (storedUsername == null || storedPassword == null) {
            System.out.println("There is no registered user!");
        } else if (storedUsername.equals(userInfo.get("username")) &&
                storedPassword.equals(userInfo.get("password"))) {
            System.out.println("Successfully logged in");
        } else {
            System.out.println("Incorrect username or password");
        }

        br.close();
    }

    private static HashMap<String, String> getUserInfo() {
        HashMap<String, String> output = new HashMap<>();
        output.put("username", validatedInput("Username"));
        output.put("password", validatedInput("Password"));
        return output;
    }

    private static String validatedInput(String prompt) {
        String input = Utils.userInput(prompt);
        for (int i = 0, n = input.length(); i < n; i++) {
            if (alphanumeric.indexOf(input.charAt(i)) == -1) {
                System.out.println("Your input must contain only alphanumeric characters!");
                return validatedInput(prompt);
            }
        }
        return input;
    }
}
