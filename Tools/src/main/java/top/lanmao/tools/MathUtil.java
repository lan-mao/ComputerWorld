package top.lanmao.tools;

/**
 * Create Date 2020/11/30 11:28:06 <br>
 * Created by lan-mao.top <br>
 * 数字工具类 <br>
 */

public class MathUtil {
    /**
     * 获取double的小数部分
     * @param number double类型
     * @return 小数
     */
    public static long getDecimal(double number) {
        String numberString = String.valueOf(number);
        String decimalString = numberString.substring(numberString.indexOf('.') + 1);
        return Long.parseLong(decimalString);
    }

    /**
     * 将int类型转为二进制的字符串
     *
     * @param num    转化的数字
     * @param format 是否在前面补0
     * @return 二进制字符串
     */
    public static String intToBinaryString(int num, boolean format) {
        String result;
        if (format) {
            result = integerToBinaryStringFormat(num, 32);
        } else {
            result = integerToBinaryStringNotFormat(num, 32);
        }
        return result;
    }

    /**
     * 将整数类型转化为二进制字符串，不在前面补0
     * @param num 要转化的数字
     * @param length 要转化的数字长度
     * @return 二进制数字
     */
    public static String integerToBinaryStringNotFormat(long num, int length) {
        StringBuilder result = new StringBuilder();
        long a = num;
        if (a < 0) {
            //a = -a;
            a = ~a;
            a ++;
            System.out.println(a);
        }
        while (a > 0) {
            result.insert(0, a % 2);
            a /= 2;
        }
        if (num < 0) {
            //int l = length - result.length();
            //for (int i = 0; i < l; i++) {
            //    result.insert(0, 1);
            //}
        }
        return result.toString();
    }
    /**
     * 将整数类型转化为定长二进制字符串，不够长前面补0
     * @param num 要转化的数字
     * @param length 要转化的数字长度
     * @return 二进制数字
     */
    public static String integerToBinaryStringFormat(long num, int length) {
        StringBuilder result = new StringBuilder();
        for (int i = length -1; i >= 0; i--) {
            result.append(num >>> i & 1);
        }
        return result.toString();
    }
}