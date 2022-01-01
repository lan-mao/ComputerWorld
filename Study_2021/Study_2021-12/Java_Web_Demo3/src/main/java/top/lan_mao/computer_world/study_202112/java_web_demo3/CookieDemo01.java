package top.lan_mao.computer_world.study_202112.java_web_demo3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Create Date 2021/12/30 19:56:50 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
@WebServlet("/1")
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            resp.getWriter().println(cookie.getName() + "=" + cookie.getValue());
        }
        Cookie cookie1 = new Cookie("test1", "123");
        // 设置cookie的有效域名
        cookie1.setDomain("localhost");
        // 设置cookie的有效路径
        cookie1.setPath("/1");
        resp.addCookie(cookie1);
        Cookie cookie2 = new Cookie("test2", "222");
        // 设置cookie有效期
        cookie2.setMaxAge(Integer.MAX_VALUE);
        resp.addCookie(cookie2);
        // 存储中文
        Cookie cookie3 = new Cookie("test4", URLEncoder.encode("小明", StandardCharsets.UTF_8));
        resp.addCookie(cookie3);
        Cookie cookie4 = new Cookie("test5", "小明");
        resp.addCookie(cookie4);
    }
}