package top.lanmao.text;

import top.lanmao.base.BaseFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Create Date 2020/12/05 22:04:04 <br>
 * Created by lan-mao.top <br>
 * 构建一个简易的计算器 <br>
 */
public class MyCalculator extends BaseFrame {
    private final TextField num1, num2, sum;
    public MyCalculator() {
        Frame frame = this;

        num1 = new TextField();
        num2 = new TextField();
        sum = new TextField();

        Button calculate = new Button("=");
        Label label = new Label("+");

        sum.setEditable(false);
        calculate.addActionListener(new MyCalculateListener());

        frame.setLayout(new FlowLayout());
        frame.add(num1);
        frame.add(label);
        frame.add(num2);
        frame.add(calculate);
        frame.add(sum);

        init();
    }

    public static void main(String[] args) {
        new MyCalculator();
    }

    class MyCalculateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int a = Integer.parseInt(num1.getText());
            int b = Integer.parseInt(num2.getText());
            sum.setText(a + b + "");
            num1.setText("");
            num2.setText("");
        }
    }
}