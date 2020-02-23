package sorm.util;

/**
 * TODO 封装常用的字符串操作
 *
 * @Date 2020/02/18 23:08
 * @Created by lan-mao.top
 */

public class StringUtils {
    /**
     * 将字符串转为UpperCamelCase风格
     * @param str 目标字符串
     * @return 首字符大写的字符串
     */
    public static String toUpperCamelCase(String str) {
        String[] list = str.split("_");
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s.toUpperCase().substring(0, 1)).append(s.substring(1));
        }
        return sb.toString();
    }

    /**
     * 将以字符串转为lowerCamelCase风格
     * @param str 目标字符串
     * @return lowerCamelCase风格
     */
    public static String toLowerCamelCase(String str){
        String[] list = str.split("_");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            if (i == 0) {
                sb.append(list[i].toLowerCase().substring(0, 1) + list[i].substring(1));
            } else {
                sb.append(list[i].toUpperCase().substring(0, 1) + list[i].substring(1));
            }
        }
        return sb.toString();
    }

    public static String javaPath2FilePath(String javaPath){
        return javaPath.replaceAll("\\.", JavaFileUtils.pathSeparator);
    }

    public static String covertFromJavaCamelCase(String str){
        char[] strArray = str.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char c : strArray) {
            if (c>='A'&&c<='Z'){
                if (result.length()>0){
                    result.append('_');
                }
                result.append((char)('a' + c - 'A'));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String name = "empName";
        System.out.println(covertFromJavaCamelCase(name));
    }
}
