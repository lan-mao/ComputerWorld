package top.lanmao.computerworld.study2021.javawebdemo2;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Create Date 2021/12/25 22:22:25 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
@WebServlet("/test1")
public class MyServlet implements Servlet {
    private int num = 0;
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("创建一个Servlet，剩余：" + ++num);
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletOutputStream servletOutputStream = res.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(servletOutputStream));
        bufferedWriter.write("TEST");
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("销毁一个Servlet，剩余：" + --num);
    }
}