package top.lanmao.listener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Create Date 2020/12/04 22:04:46 <br>
 * Created by lan-mao.top <br>
 * 使用监听器 <br>
 */
public class TestListener {
    public static void main(String[] args) {
        Frame frame = new Frame();

        Button button1 = new Button("start");
        Button button2 = new Button("stop");

        //设置按钮触发会返回的信息，默认是按钮的label内容
        button2.setActionCommand("this is 'stop' button");

        //当按钮触发时会调用的方法
        button1.addActionListener(TestListener::listenerAction);
        button2.addActionListener(TestListener::listenerAction);

        frame.add(button1,BorderLayout.EAST);
        frame.add(button2,BorderLayout.WEST);
        frame.pack();
        frame.setSize(100, 100);
        frame.setVisible(true);

    }

    private static void listenerAction(ActionEvent event) {
        System.out.println(event.getActionCommand());
    }

    private static void closeWindow (Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}