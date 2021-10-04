package top.lan_mao.javase.base;

import java.util.Arrays;

/**
 * Create Date 2021/01/10 11:08:16 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 数组类的使用 <br>
 */
public class ArraysDemo {
    public static void main(String[] args) {
        int[] array = {100,20,193,293494,3298,1,1929394,122};
        Arrays.fill(array, 10);
        System.out.println(Arrays.toString(array));
    }
}
