import java.util.regex.*;

public class TestingGrounds {
    enum numbers {
        ZERO, ONE, TWO, THREE, FOUR
    }

    public static void main(String[] args) {
        Pattern p = Pattern.compile("[hH]ello");
        Matcher m = p.matcher("Hello");
        System.out.println(m.find());

        System.out.println(numbers.FOUR.compareTo(numbers.ZERO));
    }
}
