package top.lanmao.scriptplatform;

import cn.hutool.log.LogFactory;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import top.lanmao.scriptplatform.suwayun.Checkin;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Create Date 2021/10/03 17:10:35 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 */
public class Launcher {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 6);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
                new BasicThreadFactory.Builder().build());

        long interval = calendar.getTimeInMillis() - System.currentTimeMillis();

        executorService.scheduleAtFixedRate(() ->{
            LogFactory.get().info("时间：" + new SimpleDateFormat("y-M-d h:m:s.S").format(new Date()));
            LogFactory.get().info(Checkin.init(args[0]).sendMailAfterCheckin());
        }, interval, 1000*60*60*24, TimeUnit.MILLISECONDS);

    }
}