package top.lan_mao.lesson01;

import java.awt.*;

/**
 * Create Date 2020/11/30 14:35:14 <br>
 * Created by lan-mao.top <br>
 * 学习窗口 <br>
 */
public class TestFrame {
    public static void main(String[] args) {
        MyFrame myFrame1 = new MyFrame(100,100, 200, 200);
        MyFrame myFrame2 = new MyFrame(300,100, 200, 200, Color.gray);
        MyFrame myFrame3 = new MyFrame(100,300, 200, 200, Color.green);
        MyFrame myFrame4 = new MyFrame(300,300, 200, 200, Color.cyan);
    }

    public static Frame getFrame() {
        Frame frame = new Frame("第一个窗口");
        //设置窗口大小
        frame.setSize(400, 500);
        //设置背景颜色
        frame.setBackground(new Color(248, 237, 4));
        //设置窗口位置
        frame.setLocation(300, 300);
        //设置窗口固定
        frame.setResizable(false);
        //去掉标题栏和边框
        frame.setUndecorated(true);
        //设置可见性
        frame.setVisible(true);
        return frame;
    }

    static class MyFrame extends Frame{
        static int num = 0; //窗口个数

        public MyFrame(int x, int y, int w, int h, Color color) throws HeadlessException {
            super("MyFrame-->" + num++);
            setBounds(x, y, w, h);
            setBackground(color);
            setUndecorated(true);
            setVisible(true);
        }
        public MyFrame(int x, int y, int w, int h) throws HeadlessException {
            super("MyFrame-->" + num++);
            setBounds(x, y, w, h);
            setVisible(true);
        }
    }
}