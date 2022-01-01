package top.lan_mao.computer_world.study_202112.java_web_demo4.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Create Date 2021/12/31 19:46:13 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
@WebServlet("/s2")
public class MySession02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String name = (String) session.getAttribute("name");
        resp.getWriter().println(name);
    }
}