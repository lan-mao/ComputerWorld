package top.lan_mao.tools;

import cn.hutool.core.date.BetweenFormater;
import cn.hutool.core.date.DateUtil;

import java.awt.*;

/**
 * Create Date 2020/12/06 15:51:46 <br>
 * Created by lan-mao.top <br>
 * 两个秒表同时显示 <br>
 */
public class DoubleStopWatch {
    public static void main(String[] args) throws InterruptedException {
        Frame frame1 = new Frame("1");
        Frame frame2 = new Frame("2");
        Label label1 = new Label();
        Label label2 = new Label();

        label1.setSize(300, 300);
        label2.setSize(300, 300);
        label1.setFont(new Font("", Font.BOLD, 30));
        label2.setFont(new Font("", Font.BOLD, 30));

        frame1.add(label1);
        frame1.setVisible(true);
        frame1.setSize(300, 300);
        frame1.setResizable(false);
        frame2.add(label2);
        frame2.setVisible(true);
        frame2.setSize(300, 300);
        frame2.setResizable(false);

        long start = System.currentTimeMillis();
        int i = 1000000;
        synchronized (new Object()) {
            while (--i > 0) {
                long now = System.currentTimeMillis() - start;
                String time = DateUtil.formatBetween(now, BetweenFormater.Level.MILLSECOND);
                label1.setText(time);
                label2.setText(time);
                //Thread.sleep(10);
            }
        }
    }
}
