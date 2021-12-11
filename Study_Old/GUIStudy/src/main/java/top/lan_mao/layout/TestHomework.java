package top.lanmao.layout;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Create Date 2020/12/03 22:20:38 <br>
 * Created by lan-mao.top <br>
 * <br>
 */
public class TestHomework {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setSize(500, 500);

        Panel left = new Panel(new GridLayout(2, 1));
        left.add(new Button("leftButton1"));
        left.add(new Button("leftButton2"));

        Panel center = new Panel(new GridLayout(4, 1));
        center.add(new Button("centerButton1"));
        center.add(new Button("centerButton2"));

        Panel centerPanel3 = new Panel(new GridLayout(1, 2));
        centerPanel3.add(new Button("centerPanel3Button1"));
        centerPanel3.add(new Button("centerPanel3Button2"));

        Panel centerPanel4 = new Panel(new GridLayout(1, 2));
        centerPanel4.add(new Button("centerPanel4Button1"));
        centerPanel4.add(new Button("centerPanel4Button2"));
        center.add(centerPanel3);
        center.add(centerPanel4);

        Panel right = new Panel(new GridLayout(2, 1));
        right.add(new Button("rightButton1"));
        right.add(new Button("rightButton2"));

        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());
        frame.add(left, BorderLayout.WEST);
        frame.add(center, BorderLayout.CENTER);
        frame.add(right, BorderLayout.EAST);

        frame.pack();
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }
}