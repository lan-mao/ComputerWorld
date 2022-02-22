package file;

import cn.hutool.core.io.FileUtil;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

/**
 * Copyright (c) 2019-present lan-mao.top
 * ComputerWorld is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 * <p>
 * Create Date 2022/02/21 10:34 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 * <br>
 */

public class ChangeFileNameByJunit {

    @Test
    void addStringBeforeName() {
        String str = "21 ";
        String path = "C:\\Users\\maxin\\Desktop";
        String name;
        List<File> files = FileUtil.loopFiles(path);
        for (File file : files) {
            name = str + file.getName();
            FileUtil.rename(file, name, true);
        }
    }

    @Test
    void testString() {
        String fileName = "22 第04周 周五 01-28.md";
        int index = fileName.lastIndexOf('周');
        System.out.println(fileName.substring(0, index + 1) + switchName(fileName.charAt(index + 1)) + fileName.substring(index + 2));
    }

    @Test
    void moveString() {
        String path = "E:\\BaiduNetdiskWorkspace\\NoteBook\\Personal\\苟日新，日日新\\新建文件夹";
        List<File> files = FileUtil.loopFiles(path);
        for (File file : files) {
            String fileName = file.getName();
            int index = fileName.lastIndexOf('周');
            String name = fileName.substring(0, index + 1) + switchName(fileName.charAt(index + 1)) + fileName.substring(index + 2);
            FileUtil.rename(file, name, true);
        }
    }

    char switchName(char str) {
        switch (str) {
            case '一': {
                return '1';
            }
            case '二': {
                return '2';
            }
            case '三': {
                return '3';
            }
            case '四': {
                return '4';
            }
            case '五': {
                return '5';
            }
            case '六': {
                return '6';
            }
            case '日': {
                return '7';
            }
            default: {
                return str;
            }
        }
    }
}