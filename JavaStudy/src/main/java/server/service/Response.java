package server.service;

import java.io.*;
import java.net.Socket;
import java.util.Date;

/**
 * 封装response信息
 *
 * @Date 2020/02/15 23:42
 * @Created by lan-mao.top
 */

public class Response implements Closeable {
    private Socket socket;
    private StringBuilder content;
    private StringBuilder headers;
    private int code;
    private long length;
    private static final String BLANK = " ";
    private static final String CRLF = "\r\n";
    private BufferedWriter bufferedWriter ;
    {
        content = new StringBuilder();
        headers = new StringBuilder();
        length = 0;
    }
    public Response(Socket socket){
        this.socket = socket;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Response(OutputStream outputStream){
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    private void setHeaders(int code){
        headers.append("HTTP/1.1").append(BLANK);
        switch (code){
            case 404:{
                headers.append(404).append(BLANK).append("NOT FOUND");
                break;
            }
            case 505:{
                headers.append(200).append(BLANK).append("SERVER ERROR");
                break;
            }
            default:{
                headers.append(200).append(BLANK).append("OK");
                break;
            }
        }
        headers.append(CRLF);
        headers.append("Date:").append(new Date()).append(CRLF);
        headers.append("Content-type:text/html;charset=UTF-8").append(CRLF);
        headers.append("Server:").append("TestServer/0.0.1").append(CRLF);
        headers.append("Content-Length:").append(length).append(CRLF);
        headers.append(CRLF);
    }
    public Response print(String content){
        this.content.append(content);
        length += content.getBytes().length;
        return this;
    }
    public Response println(String content){
        return print(content + "\n");
    }
    public void send(int code){
        setHeaders(code);
        System.out.println("------------");
        System.out.println(headers);
        System.out.println(content);
        System.out.println("------------");
        try {
            bufferedWriter.append(headers).append(content);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws IOException {
        if (socket!=null){
            socket.shutdownOutput();
        }else {
            if (bufferedWriter!=null){
                bufferedWriter.close();
            }
        }
    }
}
