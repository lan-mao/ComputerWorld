package collection;

public class MyHashMap<K,V> {

    private HashNode<K,V>[] table;  //位桶数组
    private int size;           //存储的键值对个数
    private static final int DEFAULT_LENGTH = 16;

    public MyHashMap() {
        table = new HashNode[DEFAULT_LENGTH];
    }

    public void put(K key, V value){
        int hash = hash(key.hashCode());
        HashNode<K,V> hashNode = new HashNode<>(hash, key, value);
        hashNode.setNext(null);
        if (table[hash] == null){
            table[hash] = hashNode;
            size++;
        } else {
            HashNode<K,V> temp = table[hash];
            HashNode<K,V> last = null;
            while (temp != null){
                if (temp.getKey().equals(key)) {
                    temp.setValue(value);
                    return;
                }
                last = temp;
                temp = temp.getNext();
            }
            last.setNext(hashNode);
            size++;
        }
    }

    public V get(K key){
        V value = null;
        int hash = hash(key.hashCode());
        HashNode<K,V> temp = table[hash];
        while(temp != null){
            if (key.equals(temp.getKey())){
                value = temp.getValue();
                break;
            }
            temp = temp.getNext();
        }
        return value;
    }

    public int hash(int hashcode){
        return hashcode & (table.length-1); //通过位运算取余
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("[");
        for (HashNode<K, V> hashNode : table) {
            if (hashNode == null)
                continue;
            while (hashNode != null){
                sb.append(hashNode.toString() + " , ");
                hashNode = hashNode.getNext();
            }
        }
        sb.setCharAt(sb.length()-1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(1,"1");
        map.put(5, "2");
        map.put(12, "3");
        map.put(12, "4");
        map.put(17, "5");
        map.put(1+16*2, "6");
        map.put(17, "7");

        System.out.println(map);
        System.out.println(map.get(12));
    }
}
class HashNode<K,V> {
    private HashNode next;
    private int hash;
    private K key;
    private V value;

    public HashNode() {
    }

    public HashNode(int hash, K key, V value) {
        this.hash = hash;
        this.key = key;
        this.value = value;
    }

    public HashNode(HashNode next, int hash, K key, V value) {
        this.next = next;
        this.hash = hash;
        this.key = key;
        this.value = value;
    }

    public HashNode getNext() {
        return next;
    }

    public void setNext(HashNode next) {
        this.next = next;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{");
        //sb.append("next=").append(next == null ? "null":next.toString());
        sb.append("hash=").append(hash);
        sb.append(", key=").append(key);
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}