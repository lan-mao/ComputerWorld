package top.lanmao.computerworld.study202112.java.web.socket;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Create Date 2021/12/17 16:27:40 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public class ReceiveFile {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1080)) {
            while (true) {
                Socket accept = serverSocket.accept();
                InputStream inputStream = accept.getInputStream();
                FileOutputStream fileOutputStream = new FileOutputStream("Test2.txt");
                byte[] fileBuffer = new byte[2048];
                int i;
                while ((i = inputStream.read(fileBuffer)) != -1) {
                    fileOutputStream.write(fileBuffer, 0, i);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}