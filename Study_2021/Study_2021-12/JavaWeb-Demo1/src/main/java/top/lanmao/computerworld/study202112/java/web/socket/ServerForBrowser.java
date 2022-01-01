package top.lanmao.computerworld.study202112.java.web.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Create Date 2021/12/17 16:47:2 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public class ServerForBrowser {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1080)){
            while(true) {
                Socket socket = serverSocket.accept();
                //InputStream inputStream = socket.getInputStream();
                //int t;
                //while ((t = inputStream.read()) != -1) {
                //    System.out.print((char) t);
                //}
                //System.out.println("--------");
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
                outputStreamWriter.write("HTTP/1.1 404 ACCEPTED\r\n");
                outputStreamWriter.write("\r\n");
                outputStreamWriter.write("abcdefg");
                outputStreamWriter.flush();
                outputStreamWriter.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}