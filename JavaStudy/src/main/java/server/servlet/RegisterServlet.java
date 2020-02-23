package server.servlet;

import server.service.Request;
import server.service.Response;
import server.service.Servlet;

/**
 *  注册servlet
 *
 * @Date 2020/02/15 16:56
 * @Created by lan-mao.top
 */

public class RegisterServlet implements Servlet {
    @Override
    public void service(Request request, Response response) {
        response.println("RegisterServlet").println("注册成功🐖");
        response.println(request.getParameters().toString());
    }
}
