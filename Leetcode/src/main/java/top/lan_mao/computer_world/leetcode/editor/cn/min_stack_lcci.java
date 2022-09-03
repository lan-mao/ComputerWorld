/**
<p>请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。</p>
<br><p><strong>示例：</strong><pre>MinStack minStack = new MinStack();<br>minStack.push(-2);<br>minStack.push(0);<br>minStack.push(-3);<br>minStack.getMin();   --&gt; 返回 -3.<br>minStack.pop();<br>minStack.top(); --&gt; 返回 0.<br>minStack.getMin(); --&gt; 返回 -2.</br></br></br></br></br></br></br></pre></p></br>

<div><div>Related Topics</div><div><li>栈</li><li>设计</li></div></div><br><div><li>👍 78</li><li>👎 0</li></div>
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
 * Create Date 2022-08-27 21:52:13 <br>
 * Leetcode信息：
 *  标题：栈的最小值
 *  编号：面试题 03.02
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 */

public class min_stack_lcci{
    public static void main(String[] args) {
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
            --valueLength;
        }

        public void push(int value) {
            if (valueLength == size) {
                size = size + (size / 2);
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
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}