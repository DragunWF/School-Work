public class BubbleSort {
    public static void main(String[] args)  { 
        int[] unsorted = { -23, 16, 25, 19, 20, 34, 7, 8, 1 };
        int[] sorted = bubbleSort(unsorted.clone());
        displayArr(unsorted, "Unsorted Array");
        displayArr(sorted, "Sorted Array");
    }

    private static void displayArr(int[] arr, String prompt) {
        System.out.print(prompt + ":");
        for (int num : arr)
            System.out.print(num + " ");
        System.out.print("\n");
    }

    private static int[] bubbleSort(int[] arr) {
        while (true) {
            boolean unsorted = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tempNum = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tempNum;
                    unsorted = true;
                }
            }
            if (!unsorted)
                break;
        }
        return arr;
    }
}
