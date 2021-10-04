package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  创建一个TCP客户端
 *
 * @Date 2020/02/15 22:12
 * @Created by lan-mao.top
 */

public class TestTCPClient {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();

    }
}
