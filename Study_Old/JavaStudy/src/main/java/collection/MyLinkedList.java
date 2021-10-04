package collection;

public class MyLinkedList<E> {

    private LinkedNode first;
    private LinkedNode<E> last;
    private int size;

    public MyLinkedList(){
        LinkedNode<E> head = new LinkedNode<>();
        head.setPrevious(head);
        head.setNext(head);
        first = head;
        last = head;
    }
    public void add (E element){
        LinkedNode<E> linkedNode = new LinkedNode<>(last,last.getNext() ,element);
        first.setPrevious(linkedNode);
        last.setNext(linkedNode);
        last = linkedNode;
        size++;
    }

    public void add (int index, E element){
        LinkedNode<E> linkedNode = findByIndex(index);
        LinkedNode<E> previous = linkedNode.getPrevious();
        LinkedNode<E> newData = new LinkedNode<>(element);
        newData.setPrevious(previous);
        newData.setNext(linkedNode);
        linkedNode.setPrevious(newData);
        previous.setNext(newData);
    }

    public E get (int index){
        return findByIndex(index).getData();
    }

    private LinkedNode<E> findByIndex (int index){
        checkIndex(index);
        LinkedNode<E> linkedNode = null;
        if (index > (size>>1)){
            linkedNode = last;
            for (int i = size-1; i >index; i--) {
                linkedNode = linkedNode.getPrevious();
            }
        } else {
            linkedNode = first.getNext();
            for (int i = 0; i < index; i++) {
                linkedNode = linkedNode.getNext();
            }
        }
        return linkedNode;
    }

    private void checkIndex(int index){
        if (index <0 || index >= size)
            throw new IndexOutOfBoundsException(String.format("索引越界。范围应为：[0,%d)。当前索引位置为：%d", size-1, index));
    }

    public E remove(int index){
        LinkedNode<E> linkedNode = findByIndex(index);
        LinkedNode<E> previous = linkedNode.getPrevious();
        LinkedNode<E> next = linkedNode.getNext();
        previous.setNext(linkedNode.getNext());
        next.setPrevious(linkedNode.getPrevious());
        if (last == linkedNode){
            last = previous;
        }
        return linkedNode.getData();
    }

    public E lastNode (){
        return last.getData();
    }

    @Override
    public String toString() {
        if (size == 0){
            return "{}";
        }
        final StringBuffer sb = new StringBuffer("MyLinkedList{");
        LinkedNode<E> linkedNode = first.getNext();
        while (linkedNode != first){
            sb.append(linkedNode.getData() + ",");
            linkedNode = linkedNode.getNext();
        }
        sb.setCharAt(sb.length()-1, '}');
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedList<String> list =new MyLinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add("No." + i);
        }
        System.out.println(list);
        list.add(99, "qw");
        System.out.println(list);
        System.out.println(list.lastNode());
    }
}
class LinkedNode<E>{

    private LinkedNode previous;  //上一个节点
    private LinkedNode next;      //下一个节点
    private E data;         //元素数据

    public LinkedNode() {
    }

    public LinkedNode(E data) {
        this.data = data;
    }

    /**
     * @param previous  上一个节点
     * @param next      下一个节点
     * @param data      元素数据
     */
    public LinkedNode(LinkedNode previous, LinkedNode next, E data) {
        this.previous = previous;
        this.next = next;
        this.data = data;
    }

    public LinkedNode getPrevious() {
        return previous;
    }

    public void setPrevious(LinkedNode previous) {
        this.previous = previous;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}