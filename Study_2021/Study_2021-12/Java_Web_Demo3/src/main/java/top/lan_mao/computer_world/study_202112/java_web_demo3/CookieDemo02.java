package top.lan_mao.computer_world.study_202112.java_web_demo3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Create Date 2021/12/30 21:32:17 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
@WebServlet("/c2")
public class CookieDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie1 = new Cookie("test", "1234");
        cookie1.setMaxAge(0);
        resp.addCookie(cookie1);
        Cookie cookie2 = new Cookie("test3", "333");
        cookie2.setPath("/c2");
        resp.addCookie(cookie2);
    }
}