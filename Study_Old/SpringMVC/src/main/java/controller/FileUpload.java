package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

/**
 * Create Date 2020/09/22 14:45:12
 * Created by lan-mao.top
 * TODO 
 *  - 文件上传
 */

@Controller
@RequestMapping("/upload")
public class FileUpload {

    @RequestMapping("/single")
    @ResponseBody
    public void fileUploadSingle(MultipartFile uploadFile) {

        File file = new File("d:/", Objects.requireNonNull(uploadFile.getOriginalFilename()));
        try {
            //将文件保存到对应目录下
            uploadFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/multiple")
    @ResponseBody
    public void fileUploadMultiples(@RequestParam MultipartFile[] uploadFiles, HttpSession session) {
        String path = session.getServletContext().getRealPath("/");
        for (MultipartFile uploadFile : uploadFiles) {
            String type = Objects.requireNonNull(uploadFile.getOriginalFilename()).substring(uploadFile.getOriginalFilename().lastIndexOf('.') + 1);
            System.out.println(uploadFile.getContentType());
            String name = UUID.randomUUID().toString() + '.' + type;
            System.out.println(name);
            File file = new File(path, name);
            try {
                //将文件保存到对应目录下
                uploadFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
