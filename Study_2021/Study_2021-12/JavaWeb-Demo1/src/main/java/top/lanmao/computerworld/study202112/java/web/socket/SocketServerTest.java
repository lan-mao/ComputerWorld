package top.lanmao.computerworld.study202112.java.web.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Create Date 2021/12/16 22:9:46 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public class SocketServerTest {
    public static void main(String[] args) {
        // 开启服务器端，对1080端口监听
        try (ServerSocket serverSocket = new ServerSocket(1080)){
            // 等待客户端连接服务器，有连接时返回一个socket对象
            Socket socket = serverSocket.accept();
            System.out.println("IP:Port -- " + socket.getInetAddress().getHostAddress() + ":" + socket.getPort());
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(reader.readLine());

            System.out.println("返回信息");
            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
            writer.write("收到\n");
            writer.flush();
            System.out.println("返回信息完成");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}