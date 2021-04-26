package LeetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Create Date 2021/04/23 10:27:08 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 最长公共前缀 <br>
 */
public class T14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        for (int index = 0; index < length; index++) {
            char temp = strs[0].charAt(index);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == index || strs[j].charAt(index) != temp) {
                    return strs[0].substring(0, index);
                }
            }
        }
        return strs[0];
    }

    /**
     * 横向比较字符串
     */
    public String longestCommonPrefixByHorizontal(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String temp = strs[0];
        for (String str : strs) {
            temp = compareString(temp, str);
        }
        return temp;
    }

    private String compareString(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (b.length() == i || a.charAt(i) != b.charAt(i)) {
                return a.substring(0, i);
            }
        }
        return a;
    }

    /**
     * 基于分治思想解决问题
     */
    public String longestCommonPrefixByDivide(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefixBySplit(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefixBySplit(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        }
        int split = (end +  start) / 2;
        String pre = longestCommonPrefixBySplit(strs, start, split);
        String suf = longestCommonPrefixBySplit(strs, split + 1, end);
        return compare(pre, suf);
    }

    private String compare(String prefix, String suffix) {
        int minLength = Math.min(prefix.length(), suffix.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            if (prefix.charAt(i) != suffix.charAt(i)) {
                return prefix.substring(0, i);
            }
        }
        return prefix.substring(0, minLength);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String[] strs = LeetCodeUtil.stringToStringArray(line);

            String ret = new T14().longestCommonPrefixByHorizontal(strs);

            System.out.println((ret));
        }
    }
}