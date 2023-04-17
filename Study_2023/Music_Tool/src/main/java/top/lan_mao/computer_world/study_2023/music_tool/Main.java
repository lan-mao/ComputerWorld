/***************************************************************************************************
 * Copyright (c) 2019-present lan-mao.top
 * ComputerWorld is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:  http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 **************************************************************************************************/

package top.lan_mao.computer_world.study_2023.music_tool;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import top.lan_mao.computer_world.tool.file.GetFilesUnderDirectory;
import top.lan_mao.computer_world.tool.file.LegalizedFileName;

import java.io.File;
import java.io.IOException;

/**
 * TODO 处理目录和名称
 *  1. 将没有专辑信息的移动至单独文件夹
 *  2. 处理专辑和作者中不能用做目录的字符
 *  3. 根据文件名获取作者等信息
 *  4. 将父目录数大于2的移出
 * Create Date 2023年4月14日10点43分 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 */
public class Main {

    public static void main(String[] args) {
        File rootDir = new File("E:\\User\\Music\\");
        // 指定音乐文件路径
        //String musicFilePath = "E:\\User\\Music\\张云雷 - 太平歌词白蛇传 (live版).mp3";
        // 创建文件对象
        //File music = new File(rootDir, "Linkin Park,Pusha T,Stormzy - Good Goodbye.flac");
        // 读取音乐文件的元数据
        //printTags(music);

        //moveOrCopyFileByArtistAndAlbum(rootDir, music);

        File[] listAudioFiles = GetFilesUnderDirectory.getListAudioFiles(rootDir);

        for (File musicFile : listAudioFiles) {

            //printTags(musicFile);
            moveOrCopyFileByArtistAndAlbum(rootDir, musicFile);
            //System.out.println();
            //try {
            //    Thread.sleep(100);
            //} catch (InterruptedException e) {
            //    throw new RuntimeException(e);
            //}
        }
    }


    public static void moveOrCopyFileByArtistAndAlbum(File rootDir, File musicFile) {
        AudioFile audioFile = null;
        try {
            audioFile = AudioFileIO.read(musicFile);
        } catch (CannotReadException | InvalidAudioFrameException | ReadOnlyFileException | TagException | IOException e) {
            e.printStackTrace();
        }
        Tag tag = audioFile.getTag();

        String newFilePath = rootDir.getPath();

        String artist = "";

        if (tag.hasField(FieldKey.ALBUM_ARTIST)) {
            artist = tag.getFirst(FieldKey.ALBUM_ARTIST);
        } else if (tag.hasField(FieldKey.ARTIST)) {
            artist = tag.getFirst(FieldKey.ARTIST);
        }
        artist = LegalizedFileName.replaceOnlyOnceCharacter(artist, "&", LegalizedFileName.BACKWARD_SLASH, LegalizedFileName.FORWARD_SLASH);
        artist = LegalizedFileName.deleteIllegalCharacter(artist);
        if (artist.length() > 250) {
            artist = artist.substring(0, 250);
        }

        newFilePath += "/" + artist;

        if (tag.hasField(FieldKey.ALBUM)) {
            newFilePath += "/" + LegalizedFileName.deleteIllegalCharacter(tag.getFirst(FieldKey.ALBUM));
        }

        File newFile = new File(newFilePath, musicFile.getName());

        System.out.println(newFile.toString());
        if (!newFile.getParentFile().exists()) {
            if (!newFile.getParentFile().mkdirs()) {
                new IOException("Could not create directory \"" + newFile.getParentFile() + '\"').printStackTrace();
            }
        }

        boolean success = musicFile.renameTo(newFile);
        //boolean success = false;
        if (success) {
            System.out.println(newFile.getPath() + "文件移动成功");
        } else {
            System.out.println(musicFile.getPath() + "文件移动失败");
        }

    }

    static void printTags(File musicFile) {
        AudioFile audioFile = null;
        try {
            audioFile = AudioFileIO.read(musicFile);
        } catch (CannotReadException | InvalidAudioFrameException | ReadOnlyFileException | TagException | IOException e) {
            e.printStackTrace();
        }
        Tag tag = audioFile.getTag();
        String tagType = tag.getClass().getSimpleName();
        // 获取音乐标题
        String title = tag.getFirst(FieldKey.TITLE);
        // 获取艺术家
        String artist = tag.getFirst(FieldKey.ARTIST);
        // 获取专辑
        String album = tag.getFirst(FieldKey.ALBUM);
        // 获取音轨号
        String track = tag.getFirst(FieldKey.TRACK);
        // 获取发行年份
        String year = tag.getFirst(FieldKey.YEAR);
        // 获取流派
        String genre = tag.getFirst(FieldKey.GENRE);
        // 输出标签数据
        System.out.println("TagType: " + tagType);
        System.out.println("Title: " + title);
        System.out.println("Artist: " + artist);
        System.out.println("Album: " + album);
        System.out.println("Track: " + track);
        System.out.println("Year: " + year);
        System.out.println("Genre: " + genre);
        System.out.println("ALBUM_ARTIST: " + tag.getFirst(FieldKey.ALBUM_ARTIST));
        System.out.println(tag.getAll(FieldKey.ARTIST));
        System.out.println(tag.getAll(FieldKey.ARTISTS));
    }
}