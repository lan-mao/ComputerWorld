package top.lan_mao.tools;

/**
 * Create Date 2020/11/30 10:12:30 <br>
 * Created by lan-mao.top <br>
 * 与时间相关的工具 <br>
 *     todo
 *      - 将重复代码模板合并
 */
public class TimeUtil {
    /**
     * 格式化一个以毫秒为单位的时间值
     * 传入的值单位为毫秒
     * @param time 毫秒
     * @return 格式化后的字符串
     */
    public static String formatTimeFromMillisecond(long time) {
        return time + "毫秒";
    }
    /**
     * 格式化一个以秒为单位的时间值
     * 传入的值单位为秒，小数点后为毫秒
     * @param time 秒.毫秒
     * @return 格式化后的字符串
     */
    public static String formatTimeFromSecond(double time) {
        long millisecond = MathUtil.getDecimal(time);
        if (millisecond > 60) {
            time += millisecond / 60;
            millisecond %= 60;
        }
        int minutes = (int) (time / 60);
        int second = (int) (time % 60);
        StringBuilder result = new StringBuilder();
        if (minutes > 0)
            result.append(formatTimeFromHours(minutes));
        if (second >= 0)
            result.append(second).append("秒");
        if (millisecond > 0)
            result.append(millisecond).append("毫秒");
        return result.toString();
    }
    /**
     * 格式化一个以分钟为单位的时间值
     * 传入的值单位为分钟，小数点后为秒数，因此只能精确到秒，如果大于60，则将转化为分钟
     * @param time 分钟.秒
     * @return 格式化后的字符串
     */
    public static String formatTimeFromMinutes(double time) {
        long seconds = MathUtil.getDecimal(time);
        if (seconds > 60) {
            time += seconds / 60;
            seconds %= 60;
        }
        int hours = (int) (time / 60);
        int minutes = (int) (time % 60);
        StringBuilder result = new StringBuilder();
        if (hours > 0)
            result.append(formatTimeFromHours(hours));
        if (minutes >= 0)
            result.append(minutes).append("分");
        if (seconds > 0)
            result.append(seconds).append("秒");
        return result.toString();
    }

    /**
     * 格式化一个以小时为单位的时间值，精确到分钟
     * @param time 小时.分钟
     * @return 格式化后的字符串
     */
    public static String formatTimeFromHours(double time) {
        long minutes = MathUtil.getDecimal(time);
        if (minutes > 60) {
            time += minutes / 60;
            minutes %= 60;
        }
        int day = (int) (time / 60);
        int hours = (int) (time % 60);

        StringBuilder result = new StringBuilder();
        if (day > 0)
            result.append(formatTimeFromDay(day));
        if (hours >= 0)
            result.append(hours).append("时");
        if (minutes > 0)
            result.append(minutes).append("分");
        return result.toString();
    }

    /**
     * 格式化一个以天为单位的时间值，精确到小时
     * @param time 天.小时
     * @return 格式化后的字符串
     */
    public static String formatTimeFromDay(double time) {
        long hours = MathUtil.getDecimal(time);
        if (hours > 24) {
            time += hours / 24;
            hours %= 24;
        }
        int days = (int) (time % 24);
        StringBuilder result = new StringBuilder();
        if (days >= 0)
            result.append(days).append("天");
        if (hours > 0)
            result.append(hours).append("时");
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(formatTimeFromMinutes(1033.59));
        System.out.println(17*60+13+0.59);
    }
}
