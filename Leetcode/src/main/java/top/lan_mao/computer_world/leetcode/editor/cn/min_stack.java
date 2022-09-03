/**
 * <p>设计一个支持 <code>push</code> ，<code>pop</code> ，<code>top</code> 操作，并能在常数时间内检索到最小元素的栈。</p>
 *
 * <p>实现 <code>MinStack</code> 类:</p>
 *
 * <ul>
 * <li><code>MinStack()</code> 初始化堆栈对象。</li>
 * <li><code>void push(int val)</code> 将元素val推入堆栈。</li>
 * <li><code>void pop()</code> 删除堆栈顶部的元素。</li>
 * <li><code>int top()</code> 获取堆栈顶部的元素。</li>
 * <li><code>int getMin()</code> 获取堆栈中的最小元素。</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * <strong>输出：</strong>
 * [null,null,null,null,-3,null,0,-2]
 *
 * <strong>解释：</strong>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --&gt; 返回 -3.
 * minStack.pop();
 * minStack.top();      --&gt; 返回 0.
 * minStack.getMin();   --&gt; 返回 -2.
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>-2<sup>31</sup>&nbsp;&lt;= val &lt;= 2<sup>31</sup>&nbsp;- 1</code></li>
 * <li><code>pop</code>、<code>top</code> 和 <code>getMin</code> 操作总是在 <strong>非空栈</strong> 上调用</li>
 * <li><code>push</code>,&nbsp;<code>pop</code>,&nbsp;<code>top</code>, and&nbsp;<code>getMin</code>最多被调用&nbsp;<code>3 * 10<sup>4</sup></code>&nbsp;次</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>栈</li><li>设计</li></div></div><br><div><li>👍 1388</li><li>👎 0</li></div>
 */

package top.lan_mao.computer_world.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Copyright (c) 2019-present lan-mao.top
 * ComputerWorld is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at: <a href="http://license.coscl.org.cn/MulanPSL2">http://license.coscl.org.cn/MulanPSL2</a>
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 * <p>
 * Create Date 2022-08-27 16:22:32 <br>
 * Leetcode信息：
 *  标题：最小栈
 *  编号：155
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 */

public class min_stack {
    public static void main(String[] args) {
        MinStack minStack = new min_stack().new MinStack();
        minStack.push(-1);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class MinStack {

        public int[] data;
        public int[] minData;
        public int valueLength;
        public int size;

        public MinStack() {
            size = 10;
            data = new int[size];
            minData = new int[size];
            valueLength = 0;
        }

        public void pop() {
            //if (valueLength <= 0) {
            //    throw new RuntimeException("栈为空");
            //}
            --valueLength;
        }

        public void push(int value) {
            if (valueLength == size) {
                size = size + (size / 2);
                //int[] a = new int[size];
                //int[] b = new int[size];
                //System.arraycopy(data, 0, a, 0, valueLength);
                //System.arraycopy(minData, 0, b, 0, valueLength);
                //data = a;
                //minData = b;
                data = Arrays.copyOf(data, size);
                minData = Arrays.copyOf(minData, size);
            }

            if (valueLength != 0) {
                minData[valueLength] = Math.min(minData[valueLength - 1], value);
            } else {
                minData[valueLength] = value;
            }
            data[valueLength] = value;
            valueLength++;
        }


        public int getMin() {
            return minData[valueLength - 1];
        }


        public int top() {
            return data[valueLength - 1];
        }

    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

//leetcode submit region end(Prohibit modification and deletion)

}