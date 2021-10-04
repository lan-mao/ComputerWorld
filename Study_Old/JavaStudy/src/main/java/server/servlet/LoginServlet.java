package server.servlet;

import server.service.Request;
import server.service.Response;
import server.service.Servlet;

/**
 * @Classname LoginServlet
 *  登录servlet
 * @Date 2020/02/15 16:53
 * @Created by lan-mao.top
 */

public class LoginServlet implements Servlet {
    @Override
    public void service(Request request, Response response) {
        System.out.println("login");
        response.println("LoginServlet").println("登陆成功(๑•̀ㅂ•́)و✧");
        response.println(request.getParameters().toString());
    }
}
