package top.lanmao.tools.file;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.util.List;

/**
 * Create Date 2022/01/01 21:49:42 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 批量删除文件名中自动添加的(1)之类后缀<br>
 */
public class ChangeFileName02 {
    public static void main(String[] args) {
        List<File> files = FileUtil.loopFiles("D:/1");
        for (File file : files) {
            String name = FileUtil.mainName(file);
            System.out.println(name);
            int begin = name.lastIndexOf('(');
            int end = name.lastIndexOf(')');
            if (begin != -1 && end != -1) {
                String substring = name.substring(begin + 1, end - 1);
                System.out.println(substring);
                if (substring.matches("d*")) {
                    String newName = name.substring(0, begin - 1);
                    try {
                        FileUtil.rename(file, newName, true, false);
                    } catch (Exception e) {
                        System.out.println(name);
                        e.printStackTrace();
                    }
                }
            }
        }
        //File file = new File("D:/1/2.txt");
        //FileUtil.rename(file, "3.txt", false);
    }
}