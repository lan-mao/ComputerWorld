package top.lanmao.scriptplatform.suwayun;

import cn.hutool.log.LogFactory;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import top.lanmao.scriptplatform.LauncherService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Create Date 2022/01/17 10:8:17 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 * <br>
 */
public class LauncherSuwayunImpl implements LauncherService {

    @Override
    public void launch(String... param) {
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
            LogFactory.get().info(Checkin.init(param[1]).sendMailAfterCheckin());
        }, interval, 1000*60*60*24, TimeUnit.MILLISECONDS);
    }
}