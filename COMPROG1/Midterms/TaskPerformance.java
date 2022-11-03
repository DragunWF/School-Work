import java.util.*;

public class TaskPerformance {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = userInput("Do you want to play the game? (1 = YES, 2 = NO)");
        int timesPlayed = 0;

        if (choice == 1) {
            while (true) {
                timesPlayed++;
                if (playGame()) {
                    int x = userInput("Congrats, you won! Do you want to play again? (1 = YES, 2 = NO)\n");
                    if (x != 1)
                        break;
                } else {
                    System.out.println("You died!");
                    break;
                }
            }
        } else {
            System.out.println("That's too bad!");
        }

        String timeStr = timesPlayed != 1 ? "times" : "time";
        System.out.println(
            String.format("You've played the game for %s %s!", timesPlayed, timeStr)
        );

        input.close();
    }

    private static boolean playGame() {
        int playerHealth = 100, enemyHealth = 100;
        int[] dmgRange = { 10, 15 }, enemyDmgRange = { 10, 15 };

        while (playerHealth > 0 && enemyHealth > 0) {
            int choice = userInput("Attack - 1\nUpgrade - 2\n");
            if (choice == 1) {
                int damage = getRandomNum(dmgRange[0], dmgRange[1]);
                int enemyDmg = getRandomNum(enemyDmgRange[0], enemyDmgRange[1]);
                enemyHealth -= damage;
                playerHealth -= enemyDmg;

                System.out.println(
                    String.format("You hit the enemy for %s damage!\n", damage)
                );
                System.out.println(
                    String.format("You got hit for %s damage!\n", enemyDmg)
                );
            } else {
                int enemyDmg = getRandomNum(enemyDmgRange[0] - 5, enemyDmgRange[1] - 5);
                playerHealth -= enemyDmg;
                
                for (int i = 0; i < dmgRange.length; i++)
                    dmgRange[i] += 5;
                
                System.out.println(
                    String.format("You upgraded your damage output to %s-%s\n", dmgRange[0], dmgRange[1])
                );
                System.out.println(
                    String.format("You got hit by the enemy for %s damage!\n", enemyDmg)
                );
            }

            System.out.println(
                String.format("Player HP: %s\n Enemy HP: %s\n", playerHealth, enemyHealth)
            );
        }

        return playerHealth > 0;
    }

    private static int userInput(String prompt) {
        System.out.println(prompt);
        return input.nextInt();
    }

    private static int getRandomNum(int min, int max) {
        return (int)(Math.random() * (max - min) + min);
    }
}
