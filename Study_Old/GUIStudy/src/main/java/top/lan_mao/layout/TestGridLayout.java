package top.lanmao.layout;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Create Date 2020/12/03 20:31:51 <br>
 * Created by lan-mao.top <br>
 * 表格布局 <br>
 */
public class TestGridLayout {
    public static void main(String[] args) {
        Frame frame = new Frame();

        frame.setLayout(new GridLayout(3,2));

        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        Button button3 = new Button("button3");
        Button button4 = new Button("button4");
        Button button5 = new Button("button5");
        Button button6 = new Button("button6");

        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);
        frame.add(button6);

        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.pack();

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}