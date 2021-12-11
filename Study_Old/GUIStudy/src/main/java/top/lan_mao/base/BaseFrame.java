package top.lanmao.base;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Create Date 2020/12/04 22:30:44 <br>
 * Created by lan-mao.top <br>
 * 新建框架的基本处理方法及一些静态方法 <br>
 */
public class BaseFrame extends Frame {


    protected void closeWindow() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    protected void init() {
        //pack();
        setVisible(true);
        closeWindow();
    }
}