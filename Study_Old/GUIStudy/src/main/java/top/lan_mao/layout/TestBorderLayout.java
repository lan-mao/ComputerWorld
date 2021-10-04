package top.lan_mao.layout;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Create Date 2020/12/03 20:22:36 <br>
 * Created by lan-mao.top <br>
 * border布局（东西南北中） <br>
 */
public class TestBorderLayout {
    public static void main(String[] args) {
        Frame frame = new Frame();

        Button east = new Button("East");
        Button west = new Button("West");
        Button south = new Button("South");
        Button north = new Button("North");
        Button center = new Button("Center");

        frame.add(east, BorderLayout.EAST);
        frame.add(west, BorderLayout.WEST);
        frame.add(south, BorderLayout.SOUTH);
        frame.add(north, BorderLayout.NORTH);
        frame.add(center, BorderLayout.CENTER);

        frame.setSize(200, 200);
        //frame.pack();
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
