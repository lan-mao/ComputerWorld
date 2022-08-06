/**
<p>给你两个&nbsp;<strong>非空</strong> 的链表，表示两个非负的整数。它们每位数字都是按照&nbsp;<strong>逆序</strong>&nbsp;的方式存储的，并且每个节点只能存储&nbsp;<strong>一位</strong>&nbsp;数字。</p>

<p>请你将两个数相加，并以相同形式返回一个表示和的链表。</p>

<p>你可以假设除了数字 0 之外，这两个数都不会以 0&nbsp;开头。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/01/02/addtwonumber1.jpg" style="width: 483px; height: 342px;" />
<pre>
<strong>输入：</strong>l1 = [2,4,3], l2 = [5,6,4]
<strong>输出：</strong>[7,0,8]
<strong>解释：</strong>342 + 465 = 807.
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>l1 = [0], l2 = [0]
<strong>输出：</strong>[0]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
<strong>输出：</strong>[8,9,9,9,0,0,0,1]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
 <li>每个链表中的节点数在范围 <code>[1, 100]</code> 内</li>
 <li><code>0 &lt;= Node.val &lt;= 9</code></li>
 <li>题目数据保证列表表示的数字不含前导零</li>
</ul>

<div><div>Related Topics</div><div><li>递归</li><li>链表</li><li>数学</li></div></div><br><div><li>👍 8438</li><li>👎 0</li></div>
*/

package top.lan_mao.computer_world.leetcode.editor.cn;

/**
 * Copyright (c) 2019-present lan-mao.top
 * ComputerWorld is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at: <a href="http://license.coscl.org.cn/MulanPSL2">http://license.coscl.org.cn/MulanPSL2</a>
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 * <p>
 * Create Date 2022-08-05 14:21:45 <br>
 * Leetcode信息：
 *  标题：两数相加
 *  编号：2
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 */

public class add_two_numbers{
    public static void main(String[] args) {
        Solution solution = new add_two_numbers().new Solution();
    }
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
/*
        × 链表是逆序的

        if (l1.val == 0) {
            return l2;
        } else if (l2.val == 0) {
            return l1;
        }
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        stack1.push(l1.val);
        while (l1.next != null) {
            stack1.push(l1.val);
        }

        stack2.push(l2.val);
        while (l2.next != null) {
            stack2.push(l2.val);
        }

        ListNode result = new ListNode();

        boolean carry = false;
        while (!stack1.empty() ||  !stack2.empty()) {
            if (stack1.empty()) {
                int a = carry ? stack2.pop() + 1 : stack2.pop();
                if (a > 9) {
                    carry = true;
                    a = 0;
                }
                result = new ListNode(a, result);
                continue;
            }
            if (stack2.empty()) {
                int a = carry ? stack1.pop() + 1 : stack1.pop();
                if (a > 9) {
                    carry = true;
                    a = 0;
                }
                result = new ListNode(a, result);
                continue;
            }
            int a = stack1.pop() + stack2.pop();
            a = carry ? a + 1 : a;
            if (a > 9) {
                a = a - 10;
                carry = true;
            }
        }

        return result;*/

        boolean carry = false;
        ListNode result = new ListNode();
        ListNode point = result;
        ListNode point1 = l1;
        ListNode point2 = l2;

        while (point1 != null || point2 != null) {
            int a = 0;
            if (point1 == null) {
                a = carry ? point2.val + 1 : point2.val;
                point2 = point2.next;
            } else if (point2 == null) {
                a = carry ? point1.val + 1 : point1.val;
                point1 = point1.next;
            } else {
                a = point1.val + point2.val;
                a = carry ? a + 1 : a;
                point1 = point1.next;
                point2 = point2.next;
            }
            if (a >= 10) {
                carry = true;
                a -= 10;
            } else {
                carry = false;
            }
            point.next = new ListNode();
            point = point.next;
            point.val = a;
        }
        if (carry) {
            point.next = new ListNode(1);
        }

        return result.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}