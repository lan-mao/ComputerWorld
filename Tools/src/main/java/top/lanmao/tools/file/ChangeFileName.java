package top.lanmao.tools.file;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.util.List;

/**
 * Create Date 2021/11/21 9:37:1 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 批量修改文件名 <br>
 */
public class ChangeFileName {
    public static void main(String[] args) {
        List<File> files = FileUtil.loopFiles("E:\\BaiduNetdiskDownload");
        for (File file : files) {
            try {
                String extName = FileUtil.extName(file);
                if ("".equals(extName)) {
                    FileUtil.rename(file, getChangeName(file), true);
                }
                System.out.println(file.getAbsolutePath());
            } catch (Exception e) {
                System.out.println(file.getAbsolutePath() + "\tError");
            }
        }
    }

    public static String getChangeName(File file) {
        String mainName = FileUtil.mainName(file);
        return mainName + ".7z";
    }
}