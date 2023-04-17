/***************************************************************************************************
 * Copyright (c) 2019-present lan-mao.top
 * ComputerWorld is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:  http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 **************************************************************************************************/

package top.lan_mao.computer_world.study_2023.music_tool;

import org.junit.jupiter.api.Test;

import java.io.File;

import static top.lan_mao.computer_world.study_2023.music_tool.Main.moveOrCopyFileByArtistAndAlbum;
import static top.lan_mao.computer_world.study_2023.music_tool.Main.printTags;

/**
 * Create Date 2023/04/16 12:56 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 */
class MainTest {

    @Test
    public void testTag() {
        File rootDir = new File("E:\\User\\Music\\");
        // 指定音乐文件路径
        //String musicFilePath = "E:\\User\\Music\\张云雷 - 太平歌词白蛇传 (live版).mp3";
        // 创建文件对象
        File music = new File(rootDir, "줄라이 (July) - My Soul.flac");
        // 读取音乐文件的元数据
        printTags(music);

        moveOrCopyFileByArtistAndAlbum(rootDir, music);

    }

}