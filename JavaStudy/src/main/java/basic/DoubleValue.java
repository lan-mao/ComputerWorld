package basic;

public class DoubleValue {
    public static void main(String[] args) {
        float a = 1.0f - 0.1f;
        System.out.println(Double.doubleToLongBits(a));
        a -= 0.1f;
        a -= 0.1f;
        System.out.println(Double.doubleToLongBits(a));
        double b = 0.1;
        System.out.println(b);
        System.out.println(b-0.1);
    }
}
