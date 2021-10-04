package server.service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 使用ServerSocket获取与浏览器的连接
 *
 * @Date 2020/02/15 21:54
 * @Created by lan-mao.top
 */

public class Server {
    private ServerSocket serverSocket;
    private int port;

    public Server() {
        this(8888);
    }

    public Server(int port) {
        this.port = port;
    }

    /**
     * 启动服务
     */
    public void start(){
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("服务器启动");
            receive();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端启动失败。。。。。。。。端口号："+port);
        }
    }

    /**
     * 接受信息并处理
     */
    public void receive(){
        while (true) {
            try {
                Socket server = serverSocket.accept();
                new Thread(() -> {
                    System.out.println("有一个客户端建立了链接");
                    Request request = new Request(server);
                    Response response = new Response(server);
                    try {
                        String url = request.getURL();
                        Servlet servlet = WebContext.getContext().getServlet(url);
                        servlet.service(request, response);
                        response.send(200);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                        response.println("505");
                        response.send(505);
                    }finally {
                        try {
                            request.close();
                            response.close();
                            server.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("连接完成-------------");
                }).start();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 停止服务
     */
    public void stop(){
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
        server.stop();
    }
}
