import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> shapes = new Stack<String>();
        shapes.push("Triangle");
        shapes.push("Circle");
        System.out.println(shapes.peek() + " is at the top of the stack.");
        shapes.pop(); // removes Circle from the stack
        System.out.println("The stack contains: " + shapes);
    }
}