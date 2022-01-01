package stream;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.NumberUtil;

import java.io.File;
import java.util.List;

/**
 * @Classname TestCommonsIO
 * 使用Commons-IO包
 * @Date 2020/02/06 16:11
 * @Created by lan-mao.top
 */

public class TestCommonsIO {
    public static void main(String[] args) {
        File file = new File("D:\\Source\\Video\\百战程序员\\05第五阶段：JAVAEE 和项目开发\\章节4：EL表达式和JSTL标签库");
        File dest = new File("D:\\Source\\Video\\百战程序员\\05第五阶段：JAVAEE 和项目开发\\章节4：EL表达式和JSTL标签库");
        int begin = 6;

    }

    public static void rename (File src, File dest, int begin){
        File[] filesList = src.listFiles();
        for (File s : filesList) {
            String name = s.getName();
            String no = name.substring(0, name.indexOf('-'));
            if (NumberUtil.isNumber(no)){
                int num = Integer.parseInt(no);
                if (num < 6) continue;
                num += begin;
                String numString = num + "";
                if (num <10){
                    numString= "0" + num;

                }
                String newName = numString + name.substring(name.indexOf('-'));
                System.out.println(newName);
                File newFile = new File(dest,newName);
                s.renameTo(newFile);
            }
        }
    }
    public static void move (File src,File dest){
        List<File> files = FileUtil.loopFiles(src);
        for (File file : files) {
            if (file.isDirectory())continue;

        }
    }
}
