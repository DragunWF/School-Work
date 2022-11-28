import java.util.*;
// MyName | BSIT105

public class TaskPerformance {
    private static final Scanner input = new Scanner(System.in);
    private static final int[][] winningConditions = {
            { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 },
            { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 },
            { 0, 4, 8 }, { 2, 4, 6 }
    };
    private static int[] board = new int[9];
    private static int gamesPlayed = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe!");

        String c;
        do {
            System.out.println("\nQuestion will repeat until you type one of the two:");
            c = userInput("Would you like to play (yes/no)");
        } while (!c.equalsIgnoreCase("yes") && !c.equalsIgnoreCase("no"));

        if (c.equals("yes")) {
            gameLoop();
            System.out.printf("Games Played: %s\nThank you for playing!\n", gamesPlayed);
        } else {
            System.out.println("That's too bad!");
        }
    }

    private static void gameLoop() {
        playGame();
        gamesPlayed++;

        while (true) {
            String c = userInput("Would you like to play again? (yes/no)");
            if (c.equalsIgnoreCase("no")) {
                break;
            } else if (c.equalsIgnoreCase("yes")) {
                playGame();
            } else {
                System.out.println("Type either yes or no!");
                continue;
            }
            System.out.println("Thanks for playing a match!");
        }
    }

    private static void playGame() {
        restartBoard();
        displayBoard();

        boolean playerTurn = firstMove();
        System.out.println("Deciding who moves first...\n");
        System.out.println(playerTurn ? "You move first!" : "A.I moves first!");

        do {

        } while (!checkWin(playerTurn ? 1 : 2));
    }

    private static void displayBoard() {
        System.out.println();
        for (int i = 1; i <= board.length; i++) {
            switch (board[i]) {
                case 0:
                    System.out.print("- ");
                    break;
                case 1:
                    System.out.print("o ");
                    break;
                case 2:
                    System.out.print("x ");
                    break;
            }

            if (i % 3 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    private static void restartBoard() {
        for (int i = 0; i < board.length; i++) {
            board[i] = 0;
        }
    }

    private static boolean checkWin(int userNum) {
        for (int i = 0; i < winningConditions.length; i++) {
            final int[] condition = winningConditions[i];
            boolean foundWin = false;

            for (int j = 0; j < condition.length; j++) {
                foundWin = true;
                if (board[condition[j]] != userNum) {
                    foundWin = false;
                    break;
                }
            }

            if (foundWin) {
                return true;
            }
        }
        return false;
    }

    private static int AIDecision() {
        return (int) Math.floor(Math.random() * board.length);
    }

    private static boolean firstMove() {
        return (int) Math.floor(Math.random() * 1) == 1;
    }

    private static String userInput(String prompt) {
        System.out.printf("%s: ", prompt);
        return input.nextLine();
    }
}
