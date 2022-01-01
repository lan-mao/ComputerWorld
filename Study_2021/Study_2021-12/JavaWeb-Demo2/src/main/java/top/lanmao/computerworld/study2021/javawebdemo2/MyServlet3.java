package top.lanmao.computerworld.study2021.javawebdemo2;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * Create Date 2021/12/28 19:34:54 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
@WebServlet("/test3")
public class MyServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        System.out.println(servletContext);
        Enumeration<String> attributeNames = servletContext.getAttributeNames();
        Iterator<String> it = attributeNames.asIterator();
        while (it.hasNext()) {
            String attributeName = it.next();
            System.out.println(attributeName);
        }

    }
}