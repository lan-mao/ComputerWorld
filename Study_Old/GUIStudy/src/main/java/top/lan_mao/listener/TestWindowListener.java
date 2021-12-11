package top.lanmao.listener;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Create Date 2020/12/07 15:53:34 <br>
 * Created by lan-mao.top <br>
 * 使用窗口监听 <br>
 */
public class TestWindowListener extends Frame {
    public TestWindowListener() {
        setSize(500, 500);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        TestWindowListener testWindowListener = new TestWindowListener();

        testWindowListener.addWindowListener(new MyWindowListener());
        testWindowListener.addWindowFocusListener(new MyWindowListener());
        testWindowListener.addWindowStateListener(new MyWindowListener());
    }
}

class MyWindowListener extends WindowAdapter {
    @Override
    public void windowOpened(WindowEvent e) {
        //窗口打开
        System.out.println("windowOpened");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        //窗口关闭
        System.out.println("windowClosing");
        //如果将窗口调用dispose()方法，会关闭窗口，但是不会关闭进程
        e.getWindow().dispose();
        //如果调用exit()方法，由于退出了虚拟机，windowClosed不会被调用
        //System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        //窗口关闭状态下调用
        //可以在windowClosing()方法中使用dispose()，会自动调用windowClosed()
        System.out.println("windowClosed");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        //窗口最小化
        System.out.println("windowIconified");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        //窗口不活动
        System.out.println("windowDeiconified");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        //窗口活动
        System.out.println("windowActivated");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        //窗口停用
        System.out.println("windowDeactivated");
    }

    @Override
    public void windowStateChanged(WindowEvent e) {
        //窗口状态改变
        System.out.println("windowStateChanged");
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
        //窗口获得焦点
        System.out.println("windowGainedFocus");
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        //窗口失去焦点
        System.out.println("windowLostFocus");
    }
}