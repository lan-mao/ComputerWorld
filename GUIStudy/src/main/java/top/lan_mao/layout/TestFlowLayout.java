package top.lan_mao.layout;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Create Date 2020/12/01 17:55:43 <br>
 * Created by lan-mao.top <br>
 * 使用流式布局 <br>
 */
public class TestFlowLayout {
    public static void main(String[] args) {
        Frame frame = new Frame();

        //组件button
        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        Button button3 = new Button("button3");
        Button button4 = new Button("button4");

        //设置为流式布局
        frame.setSize(200, 200);

        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        //frame.setLayout(new FlowLayout());
        //frame.setLayout(new FlowLayout(FlowLayout.LEFT));
        frame.setLayout(new FlowLayout(FlowLayout.RIGHT));

        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
