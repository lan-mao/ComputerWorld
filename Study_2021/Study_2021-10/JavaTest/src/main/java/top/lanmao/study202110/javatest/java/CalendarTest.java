package top.lanmao.study202110.javatest.java;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Create Date 2021/10/28 9:46:7 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 测试使用Calendar <br>
 */
public class CalendarTest {

    static void getCalendar() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int weekday = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        int hourOf12 = calendar.get(Calendar.HOUR);
        // 表示上午还是下午
        int hourOfAmOrPm = calendar.get(Calendar.AM_PM);
        String amOrPm = hourOfAmOrPm == Calendar.AM ? "上午" : "下午";
        int hourOf24 = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        int millisecond = calendar.get(Calendar.MILLISECOND);
        int timeZone = calendar.get(Calendar.ZONE_OFFSET) / 1000 / 60 / 60;

        System.out.printf("今天是%d年%d月%d日 星期%d 今年第%d天\n本周是本年第%d周，是本月第%d周\n现在是GMT%d %s %d:%d:%d.%d\n",
                            year, month, day, weekday, dayOfYear, weekOfYear, weekOfMonth, timeZone, amOrPm, hourOf24, minute, second, millisecond);

    }

    static void setCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 9);
        calendar.set(Calendar.MINUTE, 10);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        System.out.println(new SimpleDateFormat("y-M-d h:m:s.S").format(calendar.getTime()));
    }

    public static void main(String[] args) {
        getCalendar();
        setCalendar();
    }
}