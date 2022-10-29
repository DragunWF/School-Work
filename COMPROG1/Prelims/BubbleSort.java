public class BubbleSort {
    public static void main(String[] args) {
        int[] unsorted = { -23, 16, 25, 19, 20, 34, 7, 8, 1 };
        int[] sorted = bubbleSort(unsorted.clone());
        displayArr(unsorted, "Unsorted Array");
        displayArr(sorted, "Sorted Array");
    }

    private static void displayArr(int[] arr, String prompt) {
        System.out.print(prompt + ": ");
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    private static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
