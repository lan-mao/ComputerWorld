package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestIterator {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("qq",1);
        map.put("qw",2);
        map.put("qe",3);
        map.put("qr",4);
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for (Map.Entry<String, Integer> entry : set) {
            System.out.println(entry.getKey() + "----------" + entry.getValue());
        }
    }
}
