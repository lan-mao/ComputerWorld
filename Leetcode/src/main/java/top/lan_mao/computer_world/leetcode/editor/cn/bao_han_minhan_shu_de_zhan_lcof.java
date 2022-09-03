/**
<p>定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。</p>

<p>&nbsp;</p>

<p><strong>示例:</strong></p>

<pre>MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --&gt; 返回 -3.
minStack.pop();
minStack.top();      --&gt; 返回 0.
minStack.min();   --&gt; 返回 -2.
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
 <li>各函数的调用总次数不超过 20000 次</li>
</ol>

<p>&nbsp;</p>

<p>注意：本题与主站 155 题相同：<a href="https://leetcode-cn.com/problems/min-stack/">https://leetcode-cn.com/problems/min-stack/</a></p>

<div><div>Related Topics</div><div><li>栈</li><li>设计</li></div></div><br><div><li>👍 381</li><li>👎 0</li></div>
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
 * Create Date 2022-08-27 21:53:29 <br>
 * Leetcode信息：
 *  标题：包含min函数的栈
 *  编号：剑指 Offer 30
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 */

public class bao_han_minhan_shu_de_zhan_lcof{
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


        public int min() {
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
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)

}