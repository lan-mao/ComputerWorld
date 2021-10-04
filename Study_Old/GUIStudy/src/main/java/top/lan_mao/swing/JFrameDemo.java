package top.lan_mao.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Create Date 2020/12/07 22:07:11 <br>
 * Created by lan-mao.top <br>
 * <br>
 */
public class JFrameDemo {

    public void init() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(100, 100, 500, 500);
        Component[] components = frame.getComponents();
        System.out.println(components.length);
        Component component = components[0];
        System.out.println(component.getName());
        System.out.println(component.getBackground());

        //JFrame所有的内容都在容器中进行
        //默认有一个容器
        Container container = frame.getContentPane();
        container.setBackground(Color.gray);
        System.out.println((components[0] == container));
        System.out.println(component.getBackground());

        //JFrame中自带的四种关闭窗口
        //EXIT_ON_CLOSE         完全退出
        //DISPOSE_ON_CLOSE      当所有的窗口都不显示后退出
        //HIDE_ON_CLOSE         隐藏窗口
        //DO_NOTHING_ON_CLOSE   什么也不做
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JFrameDemo().init();
    }
}
