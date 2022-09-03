/**
<p>用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 <code>appendTail</code> 和 <code>deleteHead</code> ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，<code>deleteHead</code>&nbsp;操作返回 -1 )</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
<strong>输出：</strong>[null,null,3,-1]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
<strong>输出：</strong>[null,-1,null,null,5,2]
</pre>

<p><strong>提示：</strong></p>

<ul>
 <li><code>1 &lt;= values &lt;= 10000</code></li>
 <li><code>最多会对&nbsp;appendTail、deleteHead 进行&nbsp;10000&nbsp;次调用</code></li>
</ul>

<div><div>Related Topics</div><div><li>栈</li><li>设计</li><li>队列</li></div></div><br><div><li>👍 596</li><li>👎 0</li></div>
*/

package top.lan_mao.computer_world.leetcode.editor.cn;

import java.util.Stack;

/**
 * Copyright (c) 2019-present lan-mao.top
 * ComputerWorld is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at: <a href="http://license.coscl.org.cn/MulanPSL2">http://license.coscl.org.cn/MulanPSL2</a>
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 * <p>
 * Create Date 2022-08-29 19:04:17 <br>
 * Leetcode信息：
 *  标题：用两个栈实现队列
 *  编号：剑指 Offer 09
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 */

public class yong_liang_ge_zhan_shi_xian_dui_lie_lcof{
    public static void main(String[] args) {
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class CQueue {
    private Stack<Integer> push;
    private Stack<Integer> pop;
    public CQueue() {
        push = new Stack<>();
        pop = new Stack<>();
    }

    public void appendTail(int value) {
        push.push(value);
    }

    public int deleteHead() {
        if (pop.isEmpty() && push.isEmpty()) {
            return -1;
        }
        pushToPop();
        return pop.pop();
    }
    private void pushToPop() {
        if (pop.isEmpty()) {
            while (!push.isEmpty()) {
                pop.push(push.pop());
            }
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

}