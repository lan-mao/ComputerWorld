package top.lanmao.computerworld.study2021.javawebdemo2;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Create Date 2021/12/28 20:30:1 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
@WebServlet("/test6")
public class MyServlet6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        InputStream resourceAsStream = servletContext.getResourceAsStream("/WEB-INF/classes/db.properties");

        Properties properties = new Properties();
        properties.load(resourceAsStream);

        String name = properties.getProperty("name");
        resp.getWriter().println(name);
    }
}