import java.util.Scanner;
import java.time.LocalTime;

public class Monday extends Weekday {
    private static final Scanner sc = new Scanner(System.in);
    private String time;

    public static void main(String[] args) {
        Monday monday = new Monday();
        System.out.print("Enter time for alarm in this format (HH:MM): ");
        monday.setAlarm(sc.nextLine());
        monday.showAlarm();
    }

    public void setAlarm(String time) {
        this.time = time;
    }

    public void showAlarm() {
        LocalTime alarm = LocalTime.parse(time);
        LocalTime now = LocalTime.now();
        if (alarm.isAfter(now)) {
            System.out.println("Alarm is set for tomorrow!");
        } else if (alarm.isBefore(now)) {
            System.out.println("I'll wake you up later!");
        }
    }
}

interface Alarm {
    public void setAlarm(String time);

    public void showAlarm();
}

abstract class Weekday implements Alarm {
}
