// Had to write it on yellow paper too

public class Seatwork {
    public enum Colors {
        RED, BLUE, GREEN, PINK, PURPLE
    }

    public static void main(String[] args) {
        Colors myColor = Colors.PURPLE;
        switch (myColor) {
            case BLUE -> System.out.println("Blue");
            case RED -> System.out.println("Red");
            case GREEN -> System.out.println("Green");
            case PINK -> System.out.println("Pink");
            case PURPLE -> System.out.println("Purple");
        }
        System.out.println(myColor.ordinal()); // index
    }
}
