package LeetCode;

import LeetCode.utill.LeetCodeUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Create Date 2021/05/05 9:00:43 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * z字形变换 <br>
 */
public class T6 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = LeetCodeUtil.stringToString(line);
            line = in.readLine();
            int numRows = Integer.parseInt(line);

            String out = convert(s, numRows);

            System.out.println(out);
        }
    }

    private static String convert(String s, int numRows) {
        s = s.substring(3, s.length() - 3);
        System.out.println(s);
        int length = s.length();
        char[][] matrix = new char[length][numRows];
        char[] chars = s.toCharArray();
        int x = 0, y = -1;
        //是否向下走
        boolean isDown = true;
        for (char aChar : chars) {
            if (isDown) {
                //向下走，x轴不变，y轴逐渐增加
                matrix[x][++y] = aChar;
                if (y == numRows - 1) {
                    isDown = false;
                }
            } else {
                //不向下走，那么斜向上走，x轴增加，y轴减少
                matrix[++x][--y] = aChar;
                if (y == 0) {
                    isDown = true;
                }
            }
        }
        char[] result = new char[length];
        int index = 0;
        for (int i = 0; i < numRows; i++) {
            //读取行
            for (int j = 0; j <= x; j++) {
                char temp = matrix[j][i];
                if (temp != '\u0000') {
                    result[index++] = temp;
                }
            }
        }
        return new String(result);
    }
}