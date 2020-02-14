package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestCollection {
    public static void main(String[] args) {
        Collection<String> list2 = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.containsAll(list2);
    }
}
