import java.util.Scanner;

public class RunAnimal {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Choose an animal. Press B for Bird, C for Cat, or D for Dog: ");
        String choice = sc.next();
        // I wanted to use a switch case here but the instructions
        // required me to use .equalsIgnoreCase() soooo yeahh....
        if (choice.equalsIgnoreCase("B")) {
            displayAnimal(new Bird());
        } else if (choice.equalsIgnoreCase("C")) {
            displayAnimal(new Cat());
        } else if (choice.equalsIgnoreCase("D")) {
            displayAnimal(new Dog());
        } else {
            System.out.println("Invalid choice!");
        }
    }

    private static void displayAnimal(Animal animal) {
        animal.eat();
        animal.sleep();
        animal.makeSound();
    }
}

abstract class Animal {
    public abstract void eat();

    public abstract void sleep();

    public abstract void makeSound();
}

class Bird extends Animal {
    public void eat() {
        System.out.println("Bird is eating seeds.");
    }

    public void sleep() {
        System.out.println("Bird is sleeping for 10-12 hours");
    }

    public void makeSound() {
        System.out.println("Tweet tweet");
    }
}

class Cat extends Animal {
    public void eat() {
        System.out.println("Cat is eating cat food");
    }

    public void sleep() {
        System.out.println("Cat is sleeping for 13-16 hours");
    }

    public void makeSound() {
        System.out.println("Meow meow");
    }

}

class Dog extends Animal {
    public void eat() {
        System.out.println("Dog is eating dog food");
    }

    public void sleep() {
        System.out.println("Dog is sleeps for 12-14 hours");
    }

    public void makeSound() {
        System.out.println("Woof woof");
    }
}