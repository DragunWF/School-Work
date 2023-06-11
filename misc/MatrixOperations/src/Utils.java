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
        }
        return output;
    }
}
