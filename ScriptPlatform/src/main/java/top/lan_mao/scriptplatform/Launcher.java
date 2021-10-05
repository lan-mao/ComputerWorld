package top.lan_mao.scriptplatform;

import cn.hutool.log.LogFactory;
import top.lan_mao.scriptplatform.suwayun.Checkin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Create Date 2021/10/03 17:10:35 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public class Launcher {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                LogFactory.get().info("运行时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
                LogFactory.get().info(Checkin.sendMailAfterCheckin());
            }
        }, new Date(), 1000*60*60*24);
    }
}