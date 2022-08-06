/**
<p>数对 <code>(a,b)</code> 由整数 <code>a</code> 和 <code>b</code> 组成，其数对距离定义为 <code>a</code> 和 <code>b</code> 的绝对差值。</p>

<p>给你一个整数数组 <code>nums</code> 和一个整数 <code>k</code> ，数对由 <code>nums[i]</code> 和 <code>nums[j]</code> 组成且满足 <code>0 &lt;= i &lt; j &lt; nums.length</code> 。返回 <strong>所有数对距离中</strong> 第 <code>k</code> 小的数对距离。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,3,1], k = 1
<strong>输出：</strong>0
<strong>解释：</strong>数对和对应的距离如下：
(1,3) -&gt; 2
(1,1) -&gt; 0
(3,1) -&gt; 2
距离第 1 小的数对是 (1,1) ，距离为 0 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,1,1], k = 2
<strong>输出：</strong>0
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,6,1], k = 3
<strong>输出：</strong>5
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
 <li><code>n == nums.length</code></li>
 <li><code>2 &lt;= n &lt;= 10<sup>4</sup></code></li>
 <li><code>0 &lt;= nums[i] &lt;= 10<sup>6</sup></code></li>
 <li><code>1 &lt;= k &lt;= n * (n - 1) / 2</code></li>
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>二分查找</li><li>排序</li></div></div><br><div><li>👍 384</li><li>👎 0</li></div>
*/

package top.lan_mao.computer_world.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (c) 2019-present lan-mao.top
 * ComputerWorld is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at: <a href="http://license.coscl.org.cn/MulanPSL2">http://license.coscl.org.cn/MulanPSL2</a>
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 * <p>
 * Create Date 2022-07-23 07:55:34 <br>
 * Leetcode信息：
 *  标题：找出第 K 小的数对距离
 *  编号：719
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 */

public class find_k_th_smallest_pair_distance{
    public static void main(String[] args) {
        Solution solution = new find_k_th_smallest_pair_distance().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
        public int smallestDistancePair(int[] nums, int k) {
/*
		× 未通过，原因：数据量太大，内存溢出

		// 记录绝对差值
		int n = nums.length;
		int[] abs = new int[(n * (n - 1) / 2)];

		int num = 0;

		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				abs[num++] = Math.abs(nums[i] - nums[j]);
			}
		}

		System.out.println(Arrays.toString(abs));
		Arrays.sort(abs);

		System.out.println(Arrays.toString(abs));

		return abs[k -1];*/

            /*
             * 想法二：先排序数据，然后计算数对的个数
             *
             * 想法三：对产生的绝对值，记录个数和值，而不是记录所有。使用map最方便。而最多能够计算出来的结果应该有n个左右吧
             *
             * */

            int n = nums.length;
            Map<Integer,Integer> absMap = new HashMap<>(n);


            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int abs = Math.abs(nums[i] - nums[j]);
                    absMap.merge(abs, 1, Integer::sum);
                }
            }

            Object[] keys = absMap.keySet().toArray();

            Arrays.sort(keys);


            for (int i = 0, num = 0; i < keys.length; i++) {
                num += absMap.get((Integer)keys[i]);
                if (num >= k) {
                    return (Integer)keys[i];
                }
            }

            return 0;

        }
}
//leetcode submit region end(Prohibit modification and deletion)

}