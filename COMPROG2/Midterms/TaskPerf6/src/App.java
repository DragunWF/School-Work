public class App {
    public static void main(String[] args) throws Exception {
        String mode;
        do {
            mode = Utils.userInput("Login or Register? Type either word").toLowerCase();
        } while (!mode.equals("login") && !mode.equals("register"));

        if (mode.equals("login")) {
            LoginAuthentication.loginUser();
        } else {
            LoginAuthentication.registerUser();
        }
    }
}
