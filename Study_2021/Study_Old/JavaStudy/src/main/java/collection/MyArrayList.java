package collection;

import java.util.*;

public class MyArrayList<E> implements List<E> {
    private E[] listDate;
    private int size;

    private final static int DEFAULT_LENGTH = 10;

    public MyArrayList(){
        this(DEFAULT_LENGTH);
    }
    public MyArrayList(int length){
        listDate = (E[])new Object[length];
    }
    public MyArrayList(E[] list){
        this();
        for (E e : list) {
            if (e != null)
                add(e);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public boolean add(E e) {
        add(size, e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        return index == -1 ?false:remove(index) != null;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E e = listDate[index];
        if (index != size) {
            System.arraycopy(listDate, index + 1, listDate, index, size - index - 1);
        }
        listDate[size--] = null;
        return e;
    }

    @Override
    @Deprecated
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    @Deprecated
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    @Deprecated
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    @Deprecated
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    @Deprecated
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    private void expansionCapacity (){
        E[] newList = (E[]) new Object[listDate.length + (listDate.length >> 2)];
        System.arraycopy(listDate, 0, newList, 0, listDate.length);
        listDate = newList;
    }

    @Override
    public void add(int index, E element) {
        if (size >= listDate.length){
            expansionCapacity();
        }
        if (index == size){
            listDate[size++] = element;
        } else {
            checkIndex(index);
            System.arraycopy(listDate, index, listDate, index + 1, size - index - 1);
            listDate[index] = element;
            size++;
        }
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (listDate[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size; i >= 0; i--) {
            if (listDate[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    @Deprecated
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    @Deprecated
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        checkIndex(fromIndex);
        checkIndex(toIndex);
        if (fromIndex < toIndex){
            int length = toIndex - fromIndex;
            E[] list = (E[]) new Object[length];
            System.arraycopy(listDate, fromIndex, list, 0, length);
            return new MyArrayList<E>(list);
        }
        return null;
    }

    void checkIndex(int index){
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException(String.format("索引越界。范围应为：[0,%d)。当前索引位置为：%d", size-1, index));
    }

    @Override
    public void clear() {
        for (int i = 0; i < listDate.length; i++) {
            listDate[i] = null;
        }
        size = 0;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return listDate[index];
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E e = listDate[index];
        listDate[index] = element;
        return e;
    }

    @Override
    public boolean contains(Object o) {
        for (E e : listDate) {
            if (e.equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    @Deprecated
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return listDate;
    }

    @Override
    @Deprecated
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public String toString() {
        if (size==0){
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("容器中共有：%d个数据。" , size));
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(listDate[i] + ",");
        }
        sb.setCharAt(sb.length()-1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> list = new MyArrayList<>();
        for (int i = 1; i <= 100; i++) {
            list.add("test_NO" + i);
        }
        System.out.println(list.size());
        list.set(100, "qwer");
        System.out.println(list);
        list.remove(10);
        System.out.println(list);

    }
}
