package top.lanmao.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Create Date 2020/12/08 17:28:16 <br>
 * Created by lan-mao.top <br>
 * 使用弹窗 <br>
 */
public class DialogDemo extends JFrame {
    public DialogDemo() throws HeadlessException {
        this.setVisible(true);
        setSize(700, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        Container contentPane = getContentPane();
        //绝对布局
        //contentPane.setLayout(null);
        pack();
        //按钮
        JButton jButton = new JButton("出现弹窗");

        jButton.addActionListener(e -> new MyDialog());
        contentPane.add(jButton);
    }

    public static void main(String[] args) {
        new DialogDemo();
    }

    private static class MyDialog extends JDialog {
        public MyDialog() {
            setVisible(true);
            setBounds(200, 200, 500, 500);
            setResizable(false);
            Container contentPane = getContentPane();
            contentPane.setLayout(new FlowLayout());
            contentPane.add(new JLabel("这是弹窗"));
            contentPane.add(new JButton("这是按钮"));
            pack();
        }
    }
}