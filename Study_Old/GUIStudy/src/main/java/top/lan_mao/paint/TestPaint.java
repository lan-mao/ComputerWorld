package top.lanmao.paint;

import top.lanmao.base.BaseFrame;

import java.awt.*;

/**
 * Create Date 2020/12/05 22:40:04 <br>
 * Created by lan-mao.top <br>
 * 使用画笔 <br>
 */
public class TestPaint {
    public static void main(String[] args) {
        new MyPaint();
    }
}

class MyPaint extends BaseFrame {
    public MyPaint() {
        setBounds(200, 200, 500, 500);
        setUndecorated(true);
        init();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        String a = "this is paint";
        g.drawString(a, 100, 10);
        g.drawBytes(a.getBytes(), 0, a.getBytes().length, 100, 100);
        g.drawChars(a.toCharArray(), 0, a.toCharArray().length, 100, 200);
        g.fillArc(100, 10, 100, 100, 0, -100);
        //画笔使用完后，建议恢复成最初的黑色
        g.setColor(Color.black);
    }
}