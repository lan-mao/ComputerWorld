package top.lanmao.computerworld.study2021.javawebdemo2;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Create Date 2021/12/28 21:22:57 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */

@WebServlet("/test7")
public class MyServlet7 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取下载文件的路径
        String realPath = "E:\\Project\\ComputerWorld\\Study_2021-12\\JavaWeb-Demo2\\src\\main\\resources\\时间.png";
        System.out.println(realPath);
        // 2. 设置下载文件名
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
        // 3. 设置响应类型为下载，并对文件名进行URL转码，否则中文等会乱码
        resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        // 4. 获取文件的输入流
        FileInputStream fileInputStream = new FileInputStream(realPath);
        // 5. 获取响应的输出流
        ServletOutputStream respOutputStream = resp.getOutputStream();
        // 6. 创建缓冲区
        int len =0;
        byte[] buffer = new byte[1024];
        // 7. 将文件输入流写入到缓冲区中，然后通过响应输出流将缓冲区数据输出到客户端
        while ((len = fileInputStream.read(buffer)) > 0) {
            respOutputStream.write(buffer,0,len);
        }
        respOutputStream.flush();

        fileInputStream.close();
        respOutputStream.close();
    }
}