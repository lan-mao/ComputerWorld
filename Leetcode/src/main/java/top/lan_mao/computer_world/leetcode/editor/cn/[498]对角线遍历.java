package top.lan_mao.computer_world.leetcode.editor.cn;

/**
<p>给你一个大小为 <code>m x n</code> 的矩阵 <code>mat</code> ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/04/10/diag1-grid.jpg" style="width: 334px; height: 334px;" />
<pre>
<strong>输入：</strong>mat = [[1,2,3],[4,5,6],[7,8,9]]
<strong>输出：</strong>[1,2,4,7,5,3,6,8,9]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>mat = [[1,2],[3,4]]
<strong>输出：</strong>[1,2,3,4]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == mat.length</code></li>
	<li><code>n == mat[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= m * n &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>5</sup> &lt;= mat[i][j] &lt;= 10<sup>5</sup></code></li>
</ul>
<div><div>Related Topics</div><div><li>数组</li><li>矩阵</li><li>模拟</li></div></div><br><div><li>👍 356</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {

		/*
		* 两个想法：
		* 1. 按一个方向走，走到头后换方向
		* 2. 将矩阵分解为小矩阵 X
		* */

		// 矩阵行数
		int m = mat.length;
		// 矩阵列数
		int n = mat[m - 1].length;

		int[] result = new int[m * n];

		// 取数为mat[i][j]，即i表示行号，j表示列号
		int i = 0, j = 0;
		// num记录结果的下标
		int num = 0;
		// 标记通过对角线的方向，为true表示从左下到右上，即i减少j增加；为false则相反
		boolean flag = true;
		while (i != m - 1 && i != n - 1) {

			if (flag) {
				while (i > 0) {
					result[num++] = mat[i--][j++];
				}
				flag = false;
			} else {
				//while ()
			}
		}

    }
}
//leetcode submit region end(Prohibit modification and deletion)