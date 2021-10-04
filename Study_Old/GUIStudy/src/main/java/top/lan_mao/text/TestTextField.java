package top.lan_mao.text;

import top.lan_mao.base.BaseFrame;

import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Create Date 2020/12/04 22:23:07 <br>
 * Created by lan-mao.top <br>
 * 使用文本框 <br>
 */
public class TestTextField {
    public static void main(String[] args) {
        new MyTextField();
    }
}

class MyTextField extends BaseFrame {
    public MyTextField() {
        //TextField是单行文本框
        TextField textField = new TextField();
        add(textField);

        //监听文本框输入的文字
        textField.addActionListener(MyTextField::getTextValue);

        textField.setForeground(Color.GRAY);
        //设置输入后显示的内容
        textField.setEchoChar('*');
        init();
    }

    private static void getTextValue(ActionEvent event) {
        //getSource方法会返回对应组件的实例
        //java.awt.TextField[textfield0,8,31,138x22,text=qq,editable,selection=2-2]
        TextField textField = (TextField) event.getSource();
        System.out.println(textField.getText());
        textField.setText("");
    }
}
