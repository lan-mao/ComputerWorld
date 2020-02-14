package thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname TestSleep
 * 使用sleep方法创建一个倒计时器
 * @Date 2020/02/08 10:44
 * @Created by lan-mao.top
 */

public class TestSleep {
    public static void main(String[] args) throws ParseException, InterruptedException {
        String destString = "2020-03-01 00:00";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date dest = dateFormat.parse(destString);
        long destTime = dest.getTime();
        long minute = 1000*60;
        long hour = minute*60;
        long day = hour*24;
        while (true){
            long now = System.currentTimeMillis();
            long left = destTime - now;
            if (left ==0) break;
            long leftDay = left/ day;
            left = left%day;
            long leftHour = left/hour;
            left = left%hour;
            long leftMinute = left/minute;
            left %= minute;
            long leftSecond = left/1000;
            left %= 1000;
            System.out.println(String.format("距离%s还有：%d天 %d时：%d分：%d秒", destString, leftDay, leftHour, leftMinute, leftSecond));
            Thread.sleep(1000);
        }
    }
}
