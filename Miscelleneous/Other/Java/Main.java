import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        DragunList dl = new DragunList();
        int limit = input("Enter the amount of items: ");
        int range = input("Enter the max range of each item: ");
        for (int i = 1; i <= limit; i++) {
            dl.push((int) Math.floor(Math.random() * range));
        }
        System.out.println("One has been popped!");
        dl.pop();
        dl.print();
    }

    private static int input(String prompt) throws Exception {
        try {
            System.out.print(prompt);
            return sc.nextInt();
        } catch (Exception error) {
            System.out.println("Invalid Input!");
            return input(prompt); // recursion
        }
    }
}

class DragunList {
    private Node head;
    private Node tail;
    private int length;

    public DragunList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void push(int val) {
        Node createdNode = new Node(val);
        if (this.length == 0) {
            this.head = createdNode;
            this.tail = createdNode;
        } else {
            this.tail.next = createdNode;
            this.tail = createdNode;
        }
        this.length++;
    }

    public void pop() {
        for (Node node = this.head; node != null; node = node.next) {
            if (node.next.next == null) {
                node.next = null;
                this.tail = node;
                break;
            }
        }
        this.length--;
    }

    public void print() {
        for (Node node = this.head; node != null; node = node.next) {
            System.out.printf("%s -> ", node.value);
        }
        System.out.println("null");
    }
}

class Node {
    public Node next;
    public Node prev;
    public int value;

    public Node(int value) {
        this.next = null;
        this.prev = null;
        this.value = value;
    }
}