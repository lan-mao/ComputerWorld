package top.lanmao.computerworld.study2021.javawebdemo2;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Create Date 2021/12/28 19:34:54 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
@WebServlet("/test4")
public class MyServlet4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        System.out.println(servletContext);

        // 此处设置响应的字符集，必须设置ContentType，否则会不起作用
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        resp.getWriter().println("名字");
    }
}