package LeetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Create Date 2021/04/26 21:29:04 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 删除有序数组中的重复项 <br>
 */
public class T26 {
    public static int removeDuplicates(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num != nums[index]) {
                nums[++index] = num;
            }
        }
        return index + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = LeetCodeUtil.stringToIntegerArray(line);

            int ret = removeDuplicates(nums);
            String out = LeetCodeUtil.integerArrayToString(nums, ret);

            System.out.print(out);
        }
    }
}