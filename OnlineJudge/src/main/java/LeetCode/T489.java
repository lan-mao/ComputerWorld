package LeetCode;

import java.util.Arrays;

/**
 * @Classname T489
 * TODO 对角线遍历
 * @Date 2020/02/06 22:07
 * @Created by lan-mao.top
 */

public class T489 implements Solution{
    public int[] findDiagonalOrder(int[][] matrix) {

    }

    @Override
    public void solution(Object... param) {
        int[][] matrix = (int[][]) param[0];
        System.out.println(Arrays.toString(findDiagonalOrder(matrix)));
    }

    public static void main(String[] args) {
        LeetCodeUtil.rootInt2dArrays(new T489());
    }
}
