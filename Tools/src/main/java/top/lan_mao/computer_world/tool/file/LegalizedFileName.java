/***************************************************************************************************
 * Copyright (c) 2019-present lan-mao.top
 * ComputerWorld is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:  http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 **************************************************************************************************/

package top.lan_mao.computer_world.tool.file;

/**
 * Create Date 2023/04/16 09:48 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 */
public class LegalizedFileName {
    public static final String INVALID_CHARACTERS = "[/\\\\:*?\"<>|]";
    public static final String FORWARD_SLASH = "/";
    public static final String BACKWARD_SLASH = "\\\\";
    public static final String COLON = ":";
    public static final String ASTERISK = "*";
    public static final String QUESTION_MARK = "?";
    public static final String DOUBLE_QUOTE = "\"";
    public static final String LESS_THAN = "<";
    public static final String GREATER_THAN = ">";
    public static final String PIPE = "|";

    /**
     * 替换字符串中的不合法字符：\/:*?<>|
     * @param fileName
     * @param replacement
     * @return
     */
    public static String replaceIllegalCharacter(String fileName, String replacement) {
        // 删除开头和结尾的空格
        fileName = fileName.trim();
        // 将不合法字符替换为"_"
        fileName = fileName.replaceAll(INVALID_CHARACTERS, replacement);
        return fileName;
    }

    public static String deleteIllegalCharacter(String fileName) {
        return replaceIllegalCharacter(fileName, "");
    }

    /**
     * 替换单个字符，字符应使用类中的常量
     * 如果字符连续出现，将只会替换一次，如 aa//bb 会替换为 aa&bb
     * @param fileName
     * @param characters 应使用类中定义的常量，可连续添加多个
     * @param replacement
     * @return
     */
    public static String replaceSingleCharacter(String fileName, String replacement, String... characters) {
        String result = fileName;
        for (String character : characters) {
            result = result.replaceAll(character + "+", replacement);
        }
        return result;
    }

    /**
     * 只替换一次，然后删除其他的不合法字符，连续的字符只会替换一次
     * @param fileName
     * @param characters
     * @param replacement
     * @return
     */
    public static String replaceOnlyOnceCharacter(String fileName, String replacement, String... characters) {
        StringBuilder builder = new StringBuilder("[");
        for (String character : characters) {
            builder.append(character);
        }
        builder.append("]+");
        return fileName.replaceAll(builder.toString(), replacement);
    }

    public static void main(String[] args) {
        String artist = "Linkin Park\\\\Pusha T\\\\Stormzy";
        artist = LegalizedFileName.replaceOnlyOnceCharacter(artist, "&", LegalizedFileName.BACKWARD_SLASH, LegalizedFileName.FORWARD_SLASH);
        System.out.println(artist);
        System.out.println(LegalizedFileName.deleteIllegalCharacter(artist));
    }
}