import java.util.*;

/**
<p>给定一个非负整数 <em><code>numRows</code>，</em>生成「杨辉三角」的前 <em><code>numRows</code> </em>行。</p>

<p><small>在「杨辉三角」中，每个数是它左上方和右上方的数的和。</small></p>

<p><img alt="" src="https://pic.leetcode-cn.com/1626927345-DZmfxB-PascalTriangleAnimated2.gif" /></p>

<p> </p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> numRows = 5
<strong>输出:</strong> [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> numRows = 1
<strong>输出:</strong> [[1]]
</pre>

<p> </p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 <= numRows <= 30</code></li>
</ul>
<div><div>Related Topics</div><div><li>数组</li><li>动态规划</li></div></div><br><div><li>👍 769</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        int[] temp = new int[numRows];
        int[] now = new int[numRows];

        temp[0] = 1;
        List<Integer> temp2 = new ArrayList<>();
        temp2.add(1);
        result.add(temp2);

        for (int i = 1; i < numRows; i++) {
            List<Integer> temp3 = new ArrayList<>();
            now[0] = now[i] = temp[i] = 1;
            temp3.add(1);
            for (int j = 1; j < i; j++) {
                now[j] = temp[j - 1] + temp[j];
                temp[j - 1] = now[j - 1];
                temp3.add(now[j]);
            }
            temp[i - 1] = now[i - 1];
            temp3.add(1);
            result.add(temp3);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)