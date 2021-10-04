package network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建一个TCP服务端
 *
 * @Date 2020/02/15 22:16
 * @Created by lan-mao.top
 */

public class TestTCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);

        //这一行代码是阻塞式的，只有当有TCP请求从这个端口进入的时候才会创建一个Socket
        Socket socket = serverSocket.accept();
        //获取请求数据
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024 * 1024];
        int length = inputStream.read(bytes);
        String data = new String(bytes, 0, length);
        System.out.println(data);
        //关闭服务
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
