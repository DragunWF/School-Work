public class Tournament {
    public static void main(String[] args) {
        final int totalPlayers = 1024;
        final int playersInAGame = 4;
        System.out.println(solve(totalPlayers, playersInAGame));
    }

    private static int solve(int totalPlayers, int playersInAGame) {
        int rounds = 0;
        while (totalPlayers != 1) {
            int quotient = totalPlayers / playersInAGame;
            rounds += quotient;
            totalPlayers = quotient;
        }
        return rounds;
    }
}
