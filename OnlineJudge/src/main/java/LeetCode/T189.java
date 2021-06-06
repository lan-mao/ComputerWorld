package LeetCode;

import LeetCode.utill.LeetCodeUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Create Date 2021/04/25 11:05:00 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 旋转数组 <br>
 */
public class T189 {
    /**
     * 原地算法，通过一次移动一个位置来省去空间，但是时间太久，并未通过
     */
public static void rotateByCycle(int[] nums, int k) {
    int length = nums.length;
    k %= length;
    if (nums.length == 1 || k == 0) {
        return;
    }
    for (int i = 0; i < k; i++) {
        int temp = nums[0];
        for (int j = 1; j < nums.length; j++) {
            int swap = temp;
            temp = nums[j];
            nums[j] = swap;
        }
        nums[0] = temp;
    }
}

    /**
     * 创建一个空的同长度数组，一次性将元素存入对应位置
     */
    public static void rotateByOtherArray(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        if (nums.length == 1 || k == 0) {
            return;
        }
        int[] result = new int[length];
        for (int i = 0; i < nums.length; i++) {
            result[(i + k) % length] = nums[i];
        }
        System.arraycopy(result, 0, nums, 0, length);
    }

    /**
     * 原地算法：通过反转字符串
     */
    public static void rotateByReverse(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        if (nums.length == 1 || k == 0) {
            return;
        }
        //数组元素全部反转
        reverse(nums, 0, length - 1);
        //反转前面的元素
        reverse(nums, 0, k - 1);
        //反转后面元素
        reverse(nums, k, length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        int split = (end - start + 1) / 2;
        for (int i = 0; i < split; i++) {
            int temp = nums[start + i];
            nums[start + i] = nums[end - i];
            nums[end - i] = temp;
        }
    }

    /**
     * 循环交换
     */
    public static void rotateBySwap(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        if (nums.length == 1 || k == 0) {
            return;
        }
        int count = 0;
        int first = 0;
        while (count < length) {
            int temp = nums[first];
            int i = first;
            do {
                i = (i + k) % length;
                int swap = nums[i];
                nums[i] = temp;
                temp = swap;
                count++;
            } while (i != first);
            first++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = LeetCodeUtil.stringToIntegerArray(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            long startTime = System.currentTimeMillis();
            rotateByReverse(nums, k);
            long endTime = System.currentTimeMillis();
            System.out.println(endTime - startTime);
            String out = LeetCodeUtil.integerArrayToString(nums);
            System.out.println(out);
        }
    }
}