package top.lanmao.javase.base;

/**
 * Create Date 2020/12/11 11:35:33 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 打印杨辉三角形 <br>
 */
public class TriangleDemo {
    public static void main(String[] args) {
        //打印n行三角形
        int n = 6;
        /**
         *          1
         *         1 1
         *        1 2 1
         *       1 3 3 1
         *      1 4 6 4 1
         *     1 5 A A 5 1
         */
        int[][] num = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int l = 1; l < n-i; l++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    num[i][j] = 1;
                } else {
                    num[i][j] = num[i - 1][j - 1] + num[i - 1][j];
                }
                System.out.print(num[i][j] + " ");
            }
            System.out.println();
        }
    }
}