package top.lanmao.computerworld.study202112.java.web.socket;

import cn.hutool.http.HttpUtil;

/**
 * Create Date 2021/12/17 23:14:0 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public class HutoolTest {
    public static void main(String[] args) {
        HttpUtil.createServer(1080).start();
    }
}