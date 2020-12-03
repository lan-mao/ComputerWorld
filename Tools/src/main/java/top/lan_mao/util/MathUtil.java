package top.lan_mao.util;

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
}
