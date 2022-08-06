/**
<p>学校打算为全体学生拍一张年度纪念照。根据要求，学生需要按照 <strong>非递减</strong> 的高度顺序排成一行。</p>

<p>排序后的高度情况用整数数组 <code>expected</code> 表示，其中 <code>expected[i]</code> 是预计排在这一行中第 <code>i</code> 位的学生的高度（<strong>下标从 0 开始</strong>）。</p>

<p>给你一个整数数组 <code>heights</code> ，表示 <strong>当前学生站位</strong> 的高度情况。<code>heights[i]</code> 是这一行中第 <code>i</code> 位学生的高度（<strong>下标从 0 开始</strong>）。</p>

<p>返回满足<em> </em><code>heights[i] != expected[i]</code> 的 <strong>下标数量</strong> 。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>heights =&nbsp;[1,1,4,2,1,3]
<strong>输出：</strong>3
<strong>解释：</strong>
高度：[1,1,<em><strong>4</strong></em>,2,<em><strong>1</strong></em>,<em><strong>3</strong></em>]
预期：[1,1,<em><strong>1</strong></em>,2,<em><strong>3</strong></em>,<em><strong>4</strong></em>]
下标 2 、4 、5 处的学生高度不匹配。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>heights = [5,1,2,3,4]
<strong>输出：</strong>5
<strong>解释：</strong>
高度：[<em><strong>5</strong></em>,<em><strong>1</strong></em>,<em><strong>2</strong></em>,<em><strong>3</strong></em>,<em><strong>4</strong></em>]
预期：[<em><strong>1</strong></em>,<em><strong>2</strong></em>,<em><strong>3</strong></em>,<em><strong>4</strong></em>,<em><strong>5</strong></em>]
所有下标的对应学生高度都不匹配。</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>heights = [1,2,3,4,5]
<strong>输出：</strong>0
<strong>解释：</strong>
高度：[1,2,3,4,5]
预期：[1,2,3,4,5]
所有下标的对应学生高度都匹配。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
 <li><code>1 &lt;= heights.length &lt;= 100</code></li>
 <li><code>1 &lt;= heights[i] &lt;= 100</code></li>
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>计数排序</li><li>排序</li></div></div><br><div><li>👍 145</li><li>👎 0</li></div>
*/

package top.lan_mao.computer_world.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Stack;

/**
 * Copyright (c) 2019-present lan-mao.top
 * ComputerWorld is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at: <a href="http://license.coscl.org.cn/MulanPSL2">http://license.coscl.org.cn/MulanPSL2</a>
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 * <p>
 * Create Date 2022-07-23 07:54:51 <br>
 * Leetcode信息：
 *  标题：高度检查器
 *  编号：1051
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 */

public class height_checker{
    public static void main(String[] args) {
        Solution solution = new height_checker().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
        public int heightChecker(int[] heights) {
        /*
        想法一：
        排序数组中的所有元素，一一对比
        排序算法：快排
        预期时间复杂度：O(nlogn) + O(n)
         */
/*
        实现一：使用Java自带的排序算法
        int[] sortArray = Arrays.copyOf(heights, heights.length);
        Arrays.sort(sortArray);
        int num = 0;
        for (int i = 0; i < sortArray.length; i++) {
            if (sortArray[i] != heights[i]) {
                num++;
            }
        }
        return num;
*/
            class Area {
                final int left,right;

                public Area(int left, int right) {
                    this.left = left;
                    this.right = right;
                }
            }
            Stack<Area> temp = new Stack<>();
            temp.push(new Area(0, heights.length - 1));
            int[] expected = Arrays.copyOf(heights, heights.length);



            // 快排思想，需要三个指针，左指针找大于分割点的，直到找到大于分割点或位置与分割点相同；右指针找小于分割点的，直到找到小于分割点或位置等于左指针
            // 需要在栈中记录左右两区的边界，
            while (!temp.empty()) {

                Area pop = temp.pop();

                // 设置模拟递归结束条件
                if (pop.left >= pop.right) {
                    continue;
                }

                int leftPoint = pop.left;
                int rightPoint = pop.right - 1;
                int splitPoint = pop.right;


                while (true) {
                    while (expected[leftPoint] <= expected[splitPoint] && leftPoint < splitPoint) {
                        leftPoint++;
                    }
                    while (expected[rightPoint] > expected[splitPoint] && rightPoint > leftPoint) {
                        rightPoint++;
                    }

                    if (leftPoint < rightPoint) {
                        int swap = expected[leftPoint];
                        expected[leftPoint] = expected[rightPoint];
                        expected[rightPoint] = swap;
                    } else if (leftPoint == rightPoint) {
                        int swap = expected[leftPoint];
                        expected[leftPoint] = expected[splitPoint];
                        expected[splitPoint] = swap;

                        temp.push(new Area(pop.left, leftPoint - 1));
                        temp.push(new Area(leftPoint + 1, pop.right));

                        break;
                    } else if (leftPoint == splitPoint) {
                        // 此情况下除分割点位置之外，全部小于分割点
                        // 全部大于分割点的情况，作为上一个情况处理
                        temp.push(new Area(pop.left, pop.right - 1));
                        break;
                    }
                    //System.out.println(Arrays.toString(expected));
                }

            }

            int num = 0;
            for (int i = 0; i < expected.length; i++) {
                if (expected[i] != heights[i]) {
                    num++;
                }
            }
            return num;

        }
}
//leetcode submit region end(Prohibit modification and deletion)

}