package LeetCode.utill;

/**
 * Create Date 2021/05/28 17:58:15 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * LeetCode的链表数据结构 <br>
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}