package top.lan_mao.listener;

import top.lan_mao.base.BaseFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Create Date 2020/12/07 21:52:16 <br>
 * Created by lan-mao.top <br>
 * 键盘监听 <br>
 */
public class TestKeyListener {
    public static void main(String[] args) {
        new MyKeyFrame();
    }
}

class MyKeyFrame extends BaseFrame {
    public MyKeyFrame() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
            }
        });
        init();
    }
}