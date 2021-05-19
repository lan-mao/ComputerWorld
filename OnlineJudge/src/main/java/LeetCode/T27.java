package LeetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Create Date 2021/04/25 20:09:17 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 移除元素 <br>
 */
public class T27 {
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        //标志是否可以跳出循环
        for (int i = 0, j = 0; ;){
            //循环找出第一个相等的元素
            while (i < nums.length && nums[i] != val) {
                count++;
                i++;
            }
            //从相等的元素开始向后找出第一个不相等的元素
            if (j < i) {
                j = i;
            }
            while (j < nums.length && nums[j] == val) {
                j++;
            }
            if (i < nums.length && j < nums.length) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                break;
            }
        }
        return count;
    }

    public static int removeElementByDoubleIndex(int[] nums, int val) {
        int index = 0;
        for (int num : nums) {
            if (num != val) {
                nums[index++] = num;
            }
        }
        return index;
    }

    public static int removeElementByFacingDoubleIndex(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[--right];
            } else {
                left++;
            }
        }
        return left;
    }

    public static int removeElementByDoubleIndexFromLeetCode(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left++] = nums[right];
            }
        }
        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = LeetCodeUtil.stringToIntegerArray(line);
            line = in.readLine();
            int val = Integer.parseInt(line);
            int ret = removeElementByFacingDoubleIndex(nums, val);
            String out = LeetCodeUtil.integerArrayToString(nums, ret);
            System.out.println(ret);
            System.out.println(out);
        }
    }
}