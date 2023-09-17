public class TriPrismDemo {
    public static void main(String[] args) {
        TriPrism<Integer> tp1 = new TriPrism<>();
        TriPrism<Double> tp2 = new TriPrism<>();
        
        tp1.setLength(10);
        tp1.setBase(5);
        tp1.setHeight(15);
        
        tp2.setLength(23.5);
        tp2.setBase(32.1);
        tp2.setHeight(27.8);
        
        System.out.printf("tp1 Volume: %s\n", calculateVolume(tp1));
        System.out.printf("tp2 Volume: %s\n", calculateVolume(tp2));
    }
    
    private static <T extends Number> double calculateVolume(TriPrism<T> obj) {
        return obj.getLength().doubleValue() * (0.5 * obj.getBase().doubleValue() * obj.getHeight().doubleValue());
    }
}

class TriPrism<T extends Number> {
    private T length;
    private T base;
    private T height;
    
    public T getLength() { return length; }
    public T getBase() { return base; }
    public T getHeight() { return height; }
    
    public void setLength(T value) { length = value; }
    public void setBase(T value) { base = value; }
    public void setHeight(T value) { height = value; }
}