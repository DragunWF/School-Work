public class Dragonfly extends Insect {
    int getNumberOfLegs() {
        return 6;
    }

    public int getNumberOfWings() {
        return 4;
    }

    public static void main(String[] args) {
        System.out.println("I'm just showing the output to show that I fixed all the methods for number 2");
        System.out.println(
                "Number 1 doesn't have an output because it's only an interface but I also fixed all its errors");

        Dragonfly dragonfly = new Dragonfly();
        System.out.printf("Number of Legs: %s\n", dragonfly.getNumberOfLegs());
        System.out.printf("Number of Wings: %s\n", dragonfly.getNumberOfLegs());
    }
}

interface HasWings {
    public int getNumberOfWings();
}

abstract class Insect implements HasWings {
    abstract int getNumberOfLegs();
    public abstract int getNumberOfWings();
}