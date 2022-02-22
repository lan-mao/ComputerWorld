package top.lan_mao.computer_world.snake;

import javax.swing.*;

/**
 * Create Date 2022/01/14 11:9:46 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public class StartGame {
    public static void main(String[] args) {
        // 1. 绘制静态窗口
        // 绘制窗口
        JFrame jFrame = new JFrame("狂神版-贪吃蛇");
        // 设置窗口大小以及显示位置
        jFrame.setBounds(100, 100, 900, 720);
        // 设置窗口大小不可更改
        jFrame.setResizable(false);
        // 设置默认的关闭按钮作用
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 2.添加绘画面板
        jFrame.add(new GamePanel());

        // 让窗口显示
        jFrame.setVisible(true);
    }
}