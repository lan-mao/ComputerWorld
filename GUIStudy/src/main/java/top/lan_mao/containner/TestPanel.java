package top.lan_mao.containner;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Create Date 2020/11/30 15:55:40 <br>
 * Created by lan-mao.top <br>
 * 学习面板组件 <br>
 */
public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame();

        Panel panel = new Panel();


        //设置布局
        frame.setLayout(null);
        //坐标
        frame.setBounds(100, 100, 500, 500);
        frame.setBackground(Color.cyan);

        //panel设置坐标，相对于frame
        panel.setBounds(50, 50, 400, 400);
        panel.setBackground(Color.green);

        //放入frame
        frame.add(panel);

        frame.setVisible(true);

        //监听事件，监听窗口关闭事件System.exit(0)
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //窗口关闭的时候需要做到的事情
                System.exit(0);
            }
        });
    }
}
