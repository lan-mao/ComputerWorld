package LeetCode;

import LeetCode.utill.LeetCodeUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author lan-mao.top
 * 对角线遍历
 */

public class T498 {
    public static int[] findDiagonalOrder(int[][] matrix) {
        return null;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] mat = LeetCodeUtil.stringToInt2dArray(line);
            int[] ret = findDiagonalOrder(mat);
            String out = LeetCodeUtil.integerArrayToString(ret);
            System.out.print(out);
        }
    }
}