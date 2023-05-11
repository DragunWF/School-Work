public class CarDemo {
    public static void main(String[] args) throws Exception {
        Car car1 = new Car(2014, Model.models.SUV, Color.colors.RED);
        Car car2 = new Car(2016, Model.models.SEDAN, Color.colors.GREEN);
        car1.display();
        car2.display();
    }
}

class Color {
    enum colors {
        RED, BLUE, GREEN, PINK, BLACK, WHITE
    }
}

class Model {
    enum models {
        SEDAN, SUV, CONVERTIBLE, HATCHBACK
    }
}

class Car {
    private int year;
    private Model.models model;
    private Color.colors color;

    public Car(int year, Model.models model, Color.colors color) {
        this.year = year;
        this.model = model;
        this.color = color;
    }

    public void display() {
        System.out.printf("Year: %s\n", this.year);
        System.out.printf("Model: %s\n", this.model);
        System.out.printf("Color: %s\n", this.color);
    }
}
