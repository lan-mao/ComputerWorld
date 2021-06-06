package LeetCode;

import LeetCode.utill.LeetCodeUtil;
import LeetCode.utill.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Create Date 2021/05/28 17:56:22 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 链表反转 <br>
 */
public class T206 {

    public static ListNode reverseList(ListNode head) {
        ListNode first = new ListNode();
        reverseList(head, first);
        if (head != null && head.next != null){
            head.next = null;
        }
        return first.next;
    }

    public static ListNode reverseList(ListNode head, ListNode first){
        if(head == null || head.next == null){
            first.next = head;
        } else{
            ListNode temp = reverseList(head.next, first);
            temp.next = head;
        }
        return head;
    }

    public static ListNode reverseListSecond(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = reverseListSecond(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = LeetCodeUtil.stringToListNode(line);
            ListNode ret = reverseListSecond(head);
            String out = LeetCodeUtil.listNodeToString(ret);
            System.out.print(out);
        }
    }
}