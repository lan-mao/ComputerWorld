/***************************************************************************************************
 * Copyright (c) 2019-present lan-mao.top
 * ComputerWorld is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:  http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 **************************************************************************************************/

package top.lan_mao.computer_world.tool.file;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

/**
 * 获取目录下的文件
 * Create Date 2023/04/16 10:55 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 */
public class GetFilesUnderDirectory {
    /**
     * 获取当前目录下的所有音频文件（mp3,flac,wav）
     * @param rootDir
     * @return
     */
    public static File[] getListAudioFiles(File rootDir) {
        File[] listAudioFiles = getListFilesByFilter(rootDir, new FileFilter() {
            @Override
            public boolean accept(File dir) {
                String nameLowerCase = dir.getName().toLowerCase();
                return nameLowerCase.endsWith(".mp3") || nameLowerCase.endsWith(".flac") || nameLowerCase.endsWith(".wav");
            }
        });
        return listAudioFiles;
    }

    /**
     * 获取所有文件
     * @param rootDir
     * @param filter
     * @return
     */
    public static File[] getListFilesByFilter(File rootDir, FileFilter filter) {
        File[] files = new File[0];
        if (rootDir.isFile()) {
            if (filter.accept(rootDir)) {
                files = new File[] {rootDir};
            }
        } else {
            files = rootDir.listFiles(filter);
        }
        return files;
    }


    public static void main(String[] args) {
        File[] listAudioFiles = getListAudioFiles(new File("E:\\User\\Music\\Lenka"));
        System.out.println(Arrays.toString(listAudioFiles));
    }
}