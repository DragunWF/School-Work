import java.util.*;

public class GetDuplicates {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int[] values = enterIntegerArray();

        HashMap<Integer, Integer> elementCount = countElements(values);
        HashSet<Integer> elements = new HashSet<Integer>();
        List<Integer> duplicates = new ArrayList<Integer>();
        for (int num : values)
            elements.add(num);

        System.out.println();
        for (Object num : elements) {
            final int count = elementCount.get(num);
            System.out.println(String.format("Element: %s | Count: %s", num, count));
            if (count >= 2)
                duplicates.add((Integer) num);
        }
        System.out.println();

        if (duplicates.size() > 0) {
            System.out.println("Duplicates of the array are:");
            displayList(duplicates);
        } else
            System.out.println("There are no duplicates!");
        System.out.println();

        input.close();
    }

    private static int[] enterIntegerArray() {
        while (true) {
            try {
                System.out.println("Enter array length:");
                final int maxLength = input.nextInt();
                int[] output = new int[maxLength];

                System.out.println(String.format("Enter %s numbers", maxLength));
                for (int i = 0; i < maxLength; i++)
                    output[i] = input.nextInt();

                return output;
            } catch (Exception error) {
                System.out.println("Please try again!");
            }
        }
    }

    private static HashMap<Integer, Integer> countElements(int[] values) {
        HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
        for (int i = 0; i < values.length; i++) {
            if (result.containsKey(values[i]))
                result.put(values[i], result.get(values[i]) + 1);
            else
                result.put(values[i], 1);
        }
        return result;
    }

    private static void displayList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
    }
}
