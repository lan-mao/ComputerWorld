/**
<p>请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（<code>push</code>、<code>top</code>、<code>pop</code> 和 <code>empty</code>）。</p>

<p>实现 <code>MyStack</code> 类：</p>

<ul>
 <li><code>void push(int x)</code> 将元素 x 压入栈顶。</li>
 <li><code>int pop()</code> 移除并返回栈顶元素。</li>
 <li><code>int top()</code> 返回栈顶元素。</li>
 <li><code>boolean empty()</code> 如果栈是空的，返回 <code>true</code> ；否则，返回 <code>false</code> 。</li>
</ul>

<p>&nbsp;</p>

<p><strong>注意：</strong></p>

<ul>
 <li>你只能使用队列的基本操作 —— 也就是&nbsp;<code>push to back</code>、<code>peek/pop from front</code>、<code>size</code> 和&nbsp;<code>is empty</code>&nbsp;这些操作。</li>
 <li>你所使用的语言也许不支持队列。&nbsp;你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列&nbsp;, 只要是标准的队列操作即可。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
<strong>输出：</strong>
[null, null, null, 2, 2, false]

<strong>解释：</strong>
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // 返回 2
myStack.pop(); // 返回 2
myStack.empty(); // 返回 False
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
 <li><code>1 &lt;= x &lt;= 9</code></li>
 <li>最多调用<code>100</code> 次 <code>push</code>、<code>pop</code>、<code>top</code> 和 <code>empty</code></li>
 <li>每次调用 <code>pop</code> 和 <code>top</code> 都保证栈不为空</li>
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你能否仅用一个队列来实现栈。</p>

<div><div>Related Topics</div><div><li>栈</li><li>设计</li><li>队列</li></div></div><br><div><li>👍 573</li><li>👎 0</li></div>
*/

package top.lan_mao.computer_world.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Copyright (c) 2019-present lan-mao.top
 * ComputerWorld is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at: <a href="http://license.coscl.org.cn/MulanPSL2">http://license.coscl.org.cn/MulanPSL2</a>
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 * <p>
 * Create Date 2022-08-29 19:04:13 <br>
 * Leetcode信息：
 *  标题：用队列实现栈
 *  编号：225
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 */

public class implement_stack_using_queues{
    public static void main(String[] args) {
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class MyStack {
    private Queue<Integer> aQueue;
    private Queue<Integer> bQueue;
    private boolean isA;
    public MyStack() {
        aQueue = new ArrayDeque<>();
        bQueue = new ArrayDeque<>();
        isA = true;
    }
    private void aExB(Queue<Integer> a, Queue<Integer> b) {
        while (a.size() > 1) {
            b.add(a.poll());
        }
    }
    public void push(int x) {
        if (isA) {
            aQueue.add(x);
        } else {
            bQueue.add(x);
        }
    }

    public int pop() {
        if (aQueue.isEmpty() && bQueue.isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        if (isA) {
            aExB(aQueue, bQueue);
            isA = false;
            return aQueue.poll();
        } else {
            aExB(bQueue, aQueue);
            isA = true;
            return bQueue.poll();
        }
    }

    public int top() {
        if (aQueue.isEmpty() && bQueue.isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        Integer result = null;
        if (isA) {
            aExB(aQueue, bQueue);
            result = aQueue.poll();
            bQueue.add(result);
        } else {
            aExB(bQueue, aQueue);
            result = bQueue.poll();
            aQueue.add(result);
        }
        isA = !isA;
        return result;
    }

    public boolean empty() {
        return aQueue.isEmpty() && bQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}