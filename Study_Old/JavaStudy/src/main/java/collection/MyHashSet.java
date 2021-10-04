package collection;

import java.util.HashMap;

public class MyHashSet<K> {
    HashMap<K, Object> map;

    private final static Object PRESENT = new Object();
    public MyHashSet(HashMap<K, Object> map) {
        this.map = map;
    }

    public int size(){
        return map.size();
    }

    public void add(K value){
        map.put(value, PRESENT);
    }
}
