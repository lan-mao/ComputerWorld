package top.lanmao.javase.base;

import top.lanmao.tools.MathUtil;

/**
 * Create Date 2020/12/10 20:26:08 <br>
 * Created by lan-mao.top <br>
 * 运算符使用 <br>
 */
public class OperatorDemo {
    public static void main(String[] args) {
        int a = -139;
        int b = 139;
        //System.out.println(Integer.toBinaryString(a).length());
        System.out.println(Integer.toBinaryString(a));
        System.out.println(MathUtil.intToBinaryString(a, false));
        System.out.println(MathUtil.intToBinaryString(a, true));
        System.out.println("=============");
        System.out.println(Integer.toBinaryString(b));
        System.out.println(MathUtil.intToBinaryString(b, true));
        System.out.println(MathUtil.intToBinaryString(b, false));


    }

}