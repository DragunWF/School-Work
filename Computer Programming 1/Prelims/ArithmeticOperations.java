public class ArithmeticOperations {
    public static void main(String[] args) {
        int[] numbers = { 25, 18, 26 };
        final int operations = 4;
        for (int num : numbers) {
            for (int i = 1; i <= operations; i++) {
                switch (i) {
                    case 1:
                        System.out.println(num + 3);
                        break;
                    case 2:
                        System.out.println(num - 3);
                        break;
                    case 3:
                        System.out.println(num * 3);
                        break;
                    default:
                        System.out.println(num / 3);
                }
            }
        }
    }
}
