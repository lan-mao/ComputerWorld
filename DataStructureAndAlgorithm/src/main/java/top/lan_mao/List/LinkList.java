package top.lan_mao.List;

import java.util.Arrays;

/**
 * Create Date 2020/03/09 11:13
 * Created by lan-mao.top
 * TODO 
 *  - 链表的实现类
 *  - 实现的是双向循环链表
 */
 
public class LinkList<E> {
    private Node first;
    private Node end;
    private int size;

    public LinkList() {
        first = new Node();
        end  = first;
        end.setNext(first);
        size = 0;
    }

    public void add(E data){
        Node<E> node = new Node();
        node.setData(data);
        node.setPre(end);
        node.setNext(end.getNext());
        end.setNext(node);
        end = node;
        size ++;
    }
    public void delete(E data){
        Node temp = first;
        while (temp.getNext() != first){
            temp = temp.getNext();
            if (temp.getData().equals(data))
                break;
        }
        delete(temp);
    }

    public void delete(Node<E> node){
        node.getNext().setPre(node.getPre());
        node.getPre().setNext(node.getNext());
        size--;
    }

    public E[] toArray(){
        Object[] list = new Object[size];
        int i =0;
        Node temp = first;
        while (temp.getNext() != first) {
            temp = temp.getNext();
            list[i++] = temp.getData();
        }
        return (E[])list;
    }
    public int length(){
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    public static void main(String[] args) {
        LinkList<Integer> list = new LinkList<>();
        for (int i =0;i<100;i++){
            list.add((int)(Math.random()*100));
        }
        System.out.println(list.length());
        System.out.println(list);
    }
}
class Node<E>{
    private E data;
    private Node<E> pre;
    private Node<E> next;

    public Node() {
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getPre() {
        return pre;
    }

    public void setPre(Node<E> pre) {
        this.pre = pre;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
