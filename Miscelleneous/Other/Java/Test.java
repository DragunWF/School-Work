package misc;

public class Test {
    public static void main(String[] args) {
        String phone = "8812-17-84";
        String[] tokens = phone.split("-");
        for (String t : phone) {
            System.out.println(t);
        }
    }
}
