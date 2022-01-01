package top.lanmao.computerworld.study202112.java.web.socket;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Create Date 2021/12/17 16:19:31 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public class SendFile {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1080)) {
            FileInputStream fileInputStream = new FileInputStream("Test.txt");
            OutputStream outputStream = socket.getOutputStream();
            byte[] fileBuffer = new byte[2048];
            int i;
            while ((i = fileInputStream.read(fileBuffer)) != -1) {
                outputStream.write(fileBuffer, 0, i);
            }
            outputStream.flush();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}