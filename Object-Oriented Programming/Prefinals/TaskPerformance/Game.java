import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Game {
    public static final Scanner sc = new Scanner(System.in);
    public static String gameChosen = "";
    private static int combatTurns = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to the game!");
        String playerName = input("Enter your name");
        selectGame();
        if (gameChosen.equals("story")) {
            StoryMode story = new StoryMode(new Player(playerName));
            story.startGame();
        } else {
            SurvivalMode survival = new SurvivalMode(new Player(playerName));
            survival.startGame();
            survival.showEnemiesDefeated();
        }
        System.out.printf("Combat turns to finish the game: %s\n", combatTurns);
        System.out.println("Thanks for playing!");
    }

    private static String selectGame() {
        System.out.println("Press 1 or 2 to select your game mode.");
        System.out.println("1 - Story\n2 - Survival");
        String choice = input("");
        switch (choice) {
            case "1":
                gameChosen = "story";
                break;
            case "2":
                gameChosen = "survival";
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
        if (!gameChosen.isEmpty()) {
            return choice;
        }
        return selectGame();
    }

    public static void fight(Enemy enemy, Player player) {
        combatTurns++;
        enemy.intro();
        boolean isPlayerTurn = true;
        while (!enemy.isDead() && !player.isDead()) {
            String playerChoice = player.chooseCombatOption();
            switch (playerChoice) {
                case "attack":
                    player.attack(enemy);
                    break;
                case "upgrade":
                    player.upgradeAttack();
                    break;
                case "heal":
                    player.heal();
                    break;
            }
            isPlayerTurn = !isPlayerTurn;

            String enemyChoice = enemy.makeCombatChoice();
            if (enemyChoice == "attack") {
                enemy.attack(player);
            } else if (enemyChoice == "heal") {
                enemy.heal();
            } else {
                System.out.printf("%s did nothing for this turn!\n", enemy.getName());
            }
        }
        System.out.printf("%s has won the fight!\n", enemy.isDead() ? player.getName() : enemy.getName());
    }

    public static String input(String prompt) {
        System.out.printf("%s: ", prompt);
        return sc.nextLine();
    }

    public static int intInput(String prompt) {
        try {
            System.out.printf("%s: ", prompt);
            return Integer.parseInt(input(prompt));
        } catch (NumberFormatException ime) {
            System.out.println("Invalid input!");
            return intInput(prompt);
        }
    }
}

abstract class Entity {
    protected String name;
    protected int minAttack, maxAttack;
    protected int health;
    protected int potions;
    protected boolean dead = false;
    private final int healAmount = 50;

    public void attack(Entity other) {
        if (!this.dead) {
            other.damage(this.getMaxAttack());
        } else {
            System.out.printf("%s is already dead and cannot attack anymore!\n", this.name);
        }
    }

    public void damage(int amount) {
        this.health -= amount;
        System.out.printf("%s has taken %s damage! %s remaining health: %s\n",
                this.name, amount, this.maxAttack, this.health);
        if (this.health <= 0) {
            death();
        }
    }

    public void heal() {
        if (this.potions > 0) {
            this.health += this.healAmount;
            this.potions--;
            System.out.printf("%s has been healed for %s! %s's health is now %s!\n",
                    this.name, this.healAmount, this.name, this.health);
            System.out.printf("%s has %s %s left!\n", this.name, this.potions,
                    this.potions > 1 ? "potions" : "potion");
        } else {
            System.out.printf("%s tries to heal but doesn't have any potions!\n", this.name);
        }
    }

    public void death() {
        System.out.printf("%s has been defeated!\n", name);
        this.dead = true;
    }

    public int getMaxAttack() {
        return (int) Math.floor(Math.random() * (this.minAttack + this.maxAttack) + this.minAttack);
    }

    public boolean isDead() {
        return this.dead;
    }

    public String getName() {
        return this.name;
    }
}

class Enemy extends Entity {
    public Enemy(String name, int attack, int health) {
        this.name = name;
        this.potions = 1;
        this.maxAttack = attack < 20 ? 20 : attack; // min attack is 20
        this.minAttack = this.maxAttack - 15;
        this.health = health;
    }

    public String makeCombatChoice() {
        int choice = (int) Math.floor(Math.random() * 3) + 1;
        if (choice == 1 && this.potions > 0) {
            return "heal";
        }
        return "attack";
    }

    public void intro() {
        System.out.printf("Enemy \"%s\" has appeared!\n", this.name);
    }
}

class Player extends Entity {
    private static final int upgradeAttackAmount = 25;
    private boolean isDefended;

    public Player(String name) {
        this.name = name;
        this.maxAttack = 25;
        this.potions = 3; // amount of times the player can heal
        this.isDefended = false;
        this.health = Game.gameChosen.equals("story") ? 100 : 500;
    }

    public String chooseCombatOption() {
        String[] choices = { "attack", "upgrade", "heal" };
        System.out.println("Combat Options: ");
        for (int i = 0; i < choices.length; i++) {
            System.out.printf("%s - %s\n", i + 1, choices[i]);
        }
        int playerChoice = Game.intInput("Option") - 1;
        if (playerChoice < 0 || playerChoice >= choices.length) {
            System.out.println("Invalid Choice!");
            return chooseCombatOption();
        }
        return choices[playerChoice];
    }

    public void defend() {
        if (this.isDefended) {
            System.out.printf("%s already has his guard up!\n", this.name);
        } else {
            System.out.printf("%s puts his guard up!\n", this.name);
        }
    }

    public void upgradeAttack() {
        final int previousAttack = this.maxAttack;
        this.maxAttack += Player.upgradeAttackAmount;
        this.minAttack += Player.upgradeAttackAmount;
        System.out.printf("%s's attack has been increased from %s to %s!\n",
                this.name, previousAttack, this.maxAttack);
    }

    public boolean isDefended() {
        return this.isDefended;
    }
}

class StoryMode implements GameMode {
    private Enemy[] enemies = {
            new Enemy("Zombie", 20, 100),
            new Enemy("Vampire", 40, 150),
            new Enemy("Death Knight", 75, 200)
    };
    private Player player;

    public StoryMode(Player player) {
        this.player = player;
    }

    public void startGame() {
        System.out.println("You have now started your journey to kill the death knight!");
        System.out.println("Along the way you encounter monsters...");
        for (int i = 0; i < enemies.length; i++) {
            Game.fight(this.enemies[i], this.player);
            if (!this.player.isDead()) {
                if (i + 1 != enemies.length) {
                    System.out.println("As you continue along the path of the swamp, you encounter new enemies!");
                } else {
                    System.out.println("The final boss has been defeated, congratulations!");
                }
            } else {
                System.out.println("You have died! The story has now ended in a tragic way...");
                break;
            }
        }
        if (!this.player.isDead()) {
            System.out.println("You have defeated all the enemies in your way! You have won!");
        }
    }
}

class SurvivalMode implements GameMode, Survival {
    private Player player;
    private int enemiesDefeated = 0;
    private Map<String, Integer> enemyTypesDefeated = new HashMap<>();
    private final int minAttack = 25, maxAttack = 50;
    private final int minHealth = 100, maxHealth = 300;
    private final String[] enemyNames = {
            "Goblin", "Vampire", "Zombie", "Troll", "Orc", "Bandit", "Baby Dragon"
    };
    private String previousChosenName = null;

    public SurvivalMode(Player player) {
        this.player = player;
    }

    public void showEnemiesDefeated() {
        if (enemiesDefeated > 0) {
            System.out.println("Enemies defeated:");
            for (String key : enemyTypesDefeated.keySet()) {
                System.out.printf("- %s x%s\n", key, enemyTypesDefeated.get(key));
            }
        }
    }

    public void startGame() {
        System.out.println("You have entered an arena with portals surrounding each entrance...");
        System.out.println("Monsters come out and now you have to fight to the death to survive!");
        while (!this.player.isDead()) {
            Enemy enemy = getRandomEnemy();
            Game.fight(enemy, player);
            if (enemy.isDead()) {
                enemiesDefeated++;
                if (enemyTypesDefeated.containsKey(enemy.getName())) {
                    int value = enemyTypesDefeated.get(enemy.getName());
                    enemyTypesDefeated.put(enemy.getName(), value + 1);
                } else {
                    enemyTypesDefeated.put(enemy.getName(), 1);
                }
            }
        }
        if (enemiesDefeated == 0) {
            System.out.println("You have defeated no enemies!");
        } else {
            System.out.println("After a valiant fight, you have finally fallen!");
            System.out.printf("You have defeated %s %s!\n", enemiesDefeated, enemiesDefeated > 1 ? "enemy" : "enemies");
        }
    }

    private Enemy getRandomEnemy() {
        return new Enemy(getRandomName(), getRandomAttack(), getRandomHealth());
    }

    private int getRandomAttack() {
        return (int) Math.floor(Math.random() * (maxAttack - minAttack) + minAttack);
    }

    private int getRandomHealth() {
        return (int) Math.floor(Math.random() * (maxHealth - minHealth) + minHealth);
    }

    private String getRandomName() {
        String chosenName = enemyNames[(int) Math.floor(Math.random() * enemyNames.length)];
        if (chosenName != this.previousChosenName) {
            this.previousChosenName = chosenName;
            return chosenName;
        }
        return getRandomName();
    }
}

interface GameMode {
    public void startGame();
}

interface Character {
    public void attack();

    public void heal();

    public void damage();

    public void death();
}

interface Survival {
    public void startGame();

    public void showEnemiesDefeated();
}