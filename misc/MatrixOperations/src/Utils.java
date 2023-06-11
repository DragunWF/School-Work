public class Utils {
    public static String getClassName(Object object) {
        String classStr = object.getClass().getName();
        String[] strArr = classStr.split("[.]");
        return strArr[strArr.length - 1];
    }

    public static String[] stringify(int[] arr) {
        String[] output = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            output[i] = String.valueOf(arr[i]);
            if (arr[i] < 10 && arr[i] >= 0) {
                output[i] = String.format(" %s ", arr[i]);
            } else if (arr[i] > -10 && arr[i] < 0) {
                output[i] += " ";
            } else if (arr[i] >= 10) {
                output[i] = String.format(" %s", arr[i]);
            }
        }
        return output;
    }

    public static int randomRange(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min) + min);
    }
}
