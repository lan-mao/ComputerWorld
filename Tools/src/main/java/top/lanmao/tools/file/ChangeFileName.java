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
        List<File> files = FileUtil.loopFiles("G:\\资源\\小白网");
        for (File file : files) {
            try {
                String extName = FileUtil.extName(file);
                switch (extName) {
                    case "7z": case "zip": case "rar":
                        break;
                    default:
                        FileUtil.rename(file, getChangeName(file), true);
                        break;
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