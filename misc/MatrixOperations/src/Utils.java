public class Utils {
    public static String getClassName(Object object) {
        String classStr = object.getClass().getName();
        String[] strArr = classStr.split("[.]");
        return strArr[strArr.length - 1];
    }
}
