package top.lan_mao.javase.base;

import java.util.Arrays;

/**
 * Create Date 2021/01/10 9:03:46 <br>
 * @author lan-mao.top <br>
 * @version 1.0
 * 方法测试 <br>
 */
public class MethodDemo {
    public static void main(String[] args) {
        System.out.println(args);
        System.out.println(Arrays.toString(args));
        test(args);
    }

    public static void test(String... i) {
        System.out.println(Arrays.toString(i));
    }
}
