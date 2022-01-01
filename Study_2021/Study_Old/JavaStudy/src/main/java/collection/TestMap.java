package collection;

import java.util.Map;
import java.util.TreeMap;

public class TestMap {
    public static void main(String[] args) {
        Map<Test, String> map = new TreeMap<>();

        map.put(new Test(1), "one");
        map.put(new Test(2), "two");
        map.put(new Test(3), "three");

        for (Test test : map.keySet()) {
            System.out.println(test + "------" + map.get(test));
        }
    }
}
class Test{
    Integer a ;

    public Test(Integer a) {
        this.a = a;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(a);
        return sb.toString();
    }
}