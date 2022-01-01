package top.lanmao.computerworld.study2021.javawebdemo2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Create Date 2021/12/28 21:56:41 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */

@WebServlet("/test8")
public class MyServlet8 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        // 获取画笔
        Graphics graphics = image.getGraphics();

        // 修改背景颜色
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, 80, 20);

        // 写字
        graphics.setColor(Color.blue);
        graphics.setFont(new Font("HYShangWeiShouShuW", Font.PLAIN, 20));
        graphics.drawString(getNum(), 0, 20);

        // 3秒刷新一次
        resp.setHeader("refresh", "3");
        // 设置响应内容类型
        resp.setContentType("image/jpg");
        // 设置浏览器不要缓存此图潘
        resp.setHeader("Pragma","No-cache");
        resp.setHeader("Cache-Control","no-cache");
        resp.setDateHeader("Expires", 0);
        // 传输信息
        ImageIO.write(image, "jpg", resp.getOutputStream());
    }

    private String getNum() {
        Random random = new Random();
        String num = random.nextInt(999_9999) + "";
        // 不够7位补零
        return "0".repeat(Math.max(0, 7 - num.length())) +
                num;
    }
}