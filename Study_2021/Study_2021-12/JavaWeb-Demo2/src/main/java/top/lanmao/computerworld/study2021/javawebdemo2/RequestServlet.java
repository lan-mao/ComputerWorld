package top.lanmao.computerworld.study2021.javawebdemo2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Create Date 2021/12/30 16:7:55 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */

@WebServlet("/request")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.getRequestDispatcher("/test4").forward(req, resp);
        //this.getServletContext().getRequestDispatcher("/test4").forward(req, resp);
        //resp.sendRedirect(req.getContextPath() + "/test4");

        req.setCharacterEncoding("utf-8");
        resp.setContentType("");
        resp.setCharacterEncoding("utf-8");
    }
}