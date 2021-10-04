package top.lan_mao.javase.base;

/**
 * Create Date 2020/12/11 11:24:01 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * for输出九九乘法表 <br>
 */
public class ForDemo {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d * %d = %d\t", i, j, i*j);
            }
            System.out.println();
        }
    }
}
