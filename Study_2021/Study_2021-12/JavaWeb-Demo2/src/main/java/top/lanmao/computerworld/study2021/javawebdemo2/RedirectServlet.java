package top.lanmao.computerworld.study2021.javawebdemo2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Create Date 2021/12/29 21:32:58 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        resp.setHeader("Location", "test8");
        resp.setStatus(HttpServletResponse.SC_FOUND); // 302
         */
        // 相当于与上面两句
        //resp.sendRedirect("test8");
        System.out.println(this.getServletContext().getContextPath());
        System.out.println(this.getServletConfig().getServletName());
        System.out.println(this.getServletName());
        System.out.println(req.getContextPath());

        resp.sendRedirect(req.getContextPath() + "/test4");
    }
}