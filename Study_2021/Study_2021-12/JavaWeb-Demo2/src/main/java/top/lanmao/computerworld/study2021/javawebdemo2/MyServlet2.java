package top.lanmao.computerworld.study2021.javawebdemo2;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * Create Date 2021/12/28 19:34:41 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
@WebServlet("/test2")
public class MyServlet2 extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        ServletContext context = servletContext.getContext("localhost:1080/manage");
        System.out.println(context);
        Enumeration<String> attributeNames = context.getAttributeNames();
        Iterator<String> iterator = attributeNames.asIterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
    }
}