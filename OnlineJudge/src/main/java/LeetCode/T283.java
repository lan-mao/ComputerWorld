package LeetCode;

import LeetCode.utill.LeetCodeUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Create Date 2021/04/27 10:02:02 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 移动零 <br>
 */
public class T283 {


private static void moveZeroes(int[] nums) {
    int index = 0;
    for (int num : nums) {
        if (num != 0) {
            nums[index++] = num;
        }
    }
    for (int i = index; i < nums.length; i++) {
        nums[i] = 0;
    }
}

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = LeetCodeUtil.stringToIntegerArray(line);

            moveZeroes(nums);
            String out = LeetCodeUtil.integerArrayToString(nums);

            System.out.print(out);
        }
    }
}