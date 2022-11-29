import java.util.*;

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
        System.out.println("\nWelcome to TicTacToe!\nx = Player\no = A.I");

        String c;
        do {
            System.out.println("\nQuestion will repeat until you type one of the two:");
            c = userInput("Would you like to play (yes/no)");
        } while (!c.equalsIgnoreCase("yes") && !c.equalsIgnoreCase("no"));

        if (c.equalsIgnoreCase("yes")) {
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

        boolean tie = true;
        do {
            if (playerTurn) {
                int playerIndex = playerDecision();
                board[playerIndex] = 1;
            } else {
                int aiIndex = AIDecision();
                board[aiIndex] = 2;
                System.out.printf("A.I has chosen board index %s!\n", aiIndex);
            }

            displayBoard();
            playerTurn = playerTurn ? false : true;

            if (!checkWin(!playerTurn ? 1 : 2)) {
                tie = false;
                break;
            }
        } while (checkTie());

        if (!tie) {
            System.out.println(!playerTurn ? "Congrats you won!" : "You lost!");
        } else {
            System.out.println("The game has tied!");
        }
    }

    private static void displayBoard() {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            switch (board[i]) {
                case 0:
                    System.out.print("- ");
                    break;
                case 1:
                    System.out.print("x ");
                    break;
                case 2:
                    System.out.print("o ");
                    break;
            }

            if ((i + 1) % 3 == 0) {
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

    private static boolean checkTie() {
        for (int tile : board) {
            if (tile == 0) {
                return false;
            }
        }
        return true;
    }

    private static int playerDecision() {
        while (true) {
            String choice = userInput("Choose an index on the board from 1 to 9");
            int index = Integer.parseInt(choice);
            if (index >= 1 && index <= 9) {
                if (board[index - 1] != 0) {
                    System.out.println("A symbol already occupies that spot!");
                    continue;
                }
                return index - 1;
            } else {
                System.out.println("Index must be within the range from 1 to 9!");
            }
        }
    }

    private static int AIDecision() {
        int aiChoice;
        do {
            aiChoice = (int) Math.floor(Math.random() * board.length);
        } while (board[aiChoice] != 0);
        return aiChoice;
    }

    private static boolean firstMove() {
        return (int) Math.floor(Math.random() * 2) == 1;
    }

    private static String userInput(String prompt) {
        System.out.printf("%s: ", prompt);
        return input.nextLine();
    }
}
