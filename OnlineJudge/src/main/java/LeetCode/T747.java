package LeetCode;

import LeetCode.utill.LeetCodeUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 至少是其他数字两倍的最大数
 * @author lan-mao.top
 */

public class T747{
    public static int dominantIndex(int[] nums) {
        int max = 0;
        int index = 0;
        int doubleMax = 0;
        int doubleMax2 =0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]){
                max = nums[i];
                index = i;
            }
            int doubleNum = nums[i] << 1;
            if (doubleNum > doubleMax ){
                doubleMax2 = doubleMax;
                doubleMax = doubleNum;
            } else if (doubleNum > doubleMax2){
                doubleMax2 = doubleNum;
            }
        }
        if (doubleMax2 <= max){
            return index;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = LeetCodeUtil.stringToIntegerArray(line);

            int ret = dominantIndex(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}