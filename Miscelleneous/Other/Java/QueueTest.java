import java.util.Queue;
import java.util.LinkedList;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> beverages = new LinkedList<String>();
        beverages.offer("Juice");
        beverages.offer("Iced Tea");
        System.out.println(beverages.peek() + " is queued first");
        beverages.clear(); // dequeue Iced Tea
        System.out.println("Element(s) in the queue: " + beverages);
    }
}
