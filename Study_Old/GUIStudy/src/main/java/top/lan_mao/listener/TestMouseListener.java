package top.lan_mao.listener;

import top.lan_mao.base.BaseFrame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Create Date 2020/12/07 15:25:05 <br>
 * Created by lan-mao.top <br>
 * 使用鼠标监听，实现画画的功能 <br>
 */
public class TestMouseListener {
    public static void main(String[] args) {
        new MyPaint();
    }
}

class MyPaint extends BaseFrame {
    private final ArrayList<Point> points = new ArrayList<>();;
    //画画需要画笔，需要监听当前鼠标的位置，需要集合存储鼠标的位置

    public MyPaint() {
        setBounds(200, 200, 600, 500);
        init();
        addMouseListener(new MyMouseListener());
    }

    @Override
    public void paint(Graphics g) {
        //监听鼠标事件
        for (Point point : points) {
            g.fillOval(point.x, point.y, 5, 5);
        }
    }

    private class MyMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            Point point = e.getPoint();
            points.add(point);
            repaint();
        }
    }
}
