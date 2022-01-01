package top.lanmao.computerworld.study202112.java.web.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Create Date 2021/12/16 22:43:3 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public class SocketClientTest {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1080)) {
            System.out.println("连接成功");
            // 获取客户端向服务端输出的流
            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
            // ！不要忘记添加换行
            writer.write("test\n");
            writer.flush();
            System.out.println("向服务器发送成功");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(reader.readLine());
        } catch (IOException e) {
            System.out.println("连接失败");
            e.printStackTrace();
        }
    }
}