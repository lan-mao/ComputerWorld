package top.lan_mao.computer_world.study_2022.springmvc_demo07_file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * Create Date 2022/01/13 19:57:26 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
@Controller
public class FileController {

    @RequestMapping("/upload")
    public String fileUpload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        if (file == null) {
            System.out.println("对象空白");
            return "rediect:/index.jsp";
        }
        // 获取文件名
        String filename = file.getOriginalFilename();

        if ("".equals(filename)) {
            return "redirect:/index.jsp";
        }

        // 上传文件的保存地址
        String realPath = request.getServletContext().getRealPath("/upload");
        File realFile = new File(realPath);
        if (!realFile.exists()) {
            realFile.mkdir();
        }

        String realFileName = realPath + File.separator + UUID.randomUUID() + "-" + filename;
        System.out.println(realFileName);

        InputStream inputStream = file.getInputStream();
        FileOutputStream outputStream = new FileOutputStream(realFileName);

        int len;
        byte[] buffer = new byte[1024];
        while ((len = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }
        outputStream.flush();
        outputStream.close();
        inputStream.close();

        return "redirect:/index.jsp";
    }

    @RequestMapping("/upload2")
    public String fileUpload2(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        String filename = file.getOriginalFilename();

        if ("".equals(filename)) {
            return "redirect:/index.jsp";
        }
        String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdirs();
        }
        String realFileName = realPath + File.separator + UUID.randomUUID() + "-" + filename;
        file.transferTo(new File(realFileName));
        return "redirect:/index.jsp";
    }

}