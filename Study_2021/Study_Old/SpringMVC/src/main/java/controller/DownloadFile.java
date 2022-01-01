package controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Create Date 2020/09/23 10:41:46
 * Created by lan-mao.top
 *
 * @author lan-mao.top
 */

@Controller
@RequestMapping("/download")
public class DownloadFile {
    @RequestMapping("/file")
    public ResponseEntity<byte[]> downloadFile() throws IOException {
        String path = "C:\\Users\\12641\\Desktop\\你好.png";
        //指定下载文件
        File file = new File(path);
        InputStream inputStream = new FileInputStream(file);
        //创建字节数组，将文件内容复制进字节数组
        byte[] body = inputStream.readAllBytes();
        //获取下载文件名，并解决文件乱码
        String fileName = new String(file.getName().getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        //编写传输信息头，通知浏览器以附件形式下载
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Disposition", "attachment;filename=" + fileName);
        //编写传输状态码
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(body, header, status);
    }

    @RequestMapping("/java-file")
    @ResponseBody
    public void downloadFile(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        String path = "C:\\Users\\12641\\Desktop\\你好.png";
        //指定下载文件
        File file = new File(path);
        String fileName = new String(file.getName().getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = response.getOutputStream();
        //创建字节数组，将文件内容复制进字节数组
        byte[] body = new byte[1024];
        int length = 0;
        while ((length = inputStream.read(body)) > 0) {
            outputStream.write(body, 0, length);
        }
        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }

}