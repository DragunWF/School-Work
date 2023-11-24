import java.util.Scanner;

public class Game {
    public static final Scanner sc = new Scanner(System.in);
    public static String gameChosen = "";

    public static void main(String[] args) {
        System.out.println("Welcome to the game!");
        Player player = new Player(input("Enter your name"));
        selectGame();
        if (gameChosen.equals("story")) {
            StoryMode story = new StoryMode(player);
            story.startGame();
        } else {
            SurvivalMode survival = new SurvivalMode();
            survival.startGame();
        }
        System.out.println("Thanks for playing!");
    }

    private static String selectGame() {
        System.out.println("Press 1 or 2 to select your game mode.");
        System.out.println("1 - Story\n2 - Survival");
        String choice = input("");
        switch (choice) {
            case "1" -> gameChosen = "story";
            case "2" -> gameChosen = "survival";
            default -> System.out.println("Invalid choice!");
        }
        if (!gameChosen.isEmpty()) {
            return choice;
        }
        return selectGame();
    }

    public static void fight(Enemy enemy, Player player) {
        enemy.intro();
        boolean isPlayerTurn = true;
        while (!enemy.isDead() && !player.isDead()) {
            String playerChoice = player.chooseCombatOption();
            switch (playerChoice) {
                case "attack" -> player.attack(enemy);
                case "defend" -> player.defend();
                case "heal" -> player.heal();
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

interface Story {
}

interface Survival {
}

abstract class Entity {
    protected String name;
    protected int attack;
    protected int health;
    protected int potions;
    protected boolean dead = false;
    private final int healAmount = 50;

    public void attack(Entity other) {
        if (!this.dead) {
            other.damage(this.getAttack());
        } else {
            System.out.printf("%s is already dead and cannot attack anymore!\n", this.name);
        }
    }

    public void damage(int amount) {
        this.health -= amount;
        System.out.printf("%s has taken %s damage! %s remaining health: %s\n",
                this.name, amount, this.attack, this.health);
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

    public int getAttack() {
        final int min = 5;
        return (int) Math.floor(Math.random() * (min + this.attack) - min);
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
        this.attack = attack < 3 ? 3 : attack; // min attack is 3
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
    private boolean isDefended;

    public Player(String name) {
        this.name = name;
        this.attack = 25;
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
        System.out.print("Option: ");
        int playerChoice = Game.sc.nextInt() - 1;
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

    public void upgradeAttack(int amount) {
        final int previousAttack = this.attack;
        this.attack += amount;
        System.out.printf("%s's attack has been increased from %s to %s!\n",
                this.name, previousAttack, this.attack);
    }

    public boolean isDefended() {
        return this.isDefended;
    }
}

class StoryMode implements GameMode, Story {
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
                System.out.println("As you continue along the path of the swamp, you encounter new enemies!");
            } else {
                System.out.println("You have died! The story has now ended in a tragic way...");
            }
        }
        if (!this.player.isDead()) {
            System.out.println("You have defeated all the enemies in your way! You have won!");
        }
    }
}

class SurvivalMode implements GameMode, Survival {
    private int enemiesDefeated;

    public void startGame() {
    }
}