/**
<p>实现一个MyQueue类，该类用两个栈来实现一个队列。</p>
<br><p><strong>示例：</strong><pre>MyQueue queue = new MyQueue();<br><br>queue.push(1);<br>queue.push(2);<br>queue.peek();  // 返回 1<br>queue.pop();   // 返回 1<br>queue.empty(); // 返回 false</br></br></br></br></br></br></pre></p><br><p><strong>说明：</strong><br>
    <ul>
     <li>你只能使用标准的栈操作 -- 也就是只有 <code>push to top</code>, <code>peek/pop from top</code>, <code>size</code> 和 <code>is empty</code> 操作是合法的。</li>
     <li>你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。</li>
     <li>假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。</li>
    </ul></br></p></br></br>

<div><div>Related Topics</div><div><li>栈</li><li>设计</li><li>队列</li></div></div><br><div><li>👍 58</li><li>👎 0</li></div>
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
 * Create Date 2022-08-29 19:04:21 <br>
 * Leetcode信息：
 *  标题：化栈为队
 *  编号：面试题 03.04
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 */

public class implement_queue_using_stacks_lcci{
    public static void main(String[] args) {
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class MyQueue {
        private Stack<Integer> push;
        private Stack<Integer> pop;
        public MyQueue() {
            push = new Stack<>();
            pop = new Stack<>();
        }

        public void push(int x) {
            push.push(x);
        }

        public int pop() {
            if (pop.isEmpty() && push.isEmpty()) {
                throw new RuntimeException("队列为空");
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
        public int peek() {
            if (pop.isEmpty() && push.isEmpty()) {
                throw new RuntimeException("队列为空");
            }
            pushToPop();
            return pop.peek();
        }

        public boolean empty() {
            return pop.isEmpty() && push.isEmpty();
        }

    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}