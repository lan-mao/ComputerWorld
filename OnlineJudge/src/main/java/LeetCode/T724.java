package LeetCode;

import LeetCode.utill.LeetCodeUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 寻找数组的中心索引
 * @author lan-mao.top
 */

public class T724{

    public static int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum+=num;
        }
        int sumLeft = 0;
        int size = nums.length;
        for (int i =0;i < size; i++){
            if (sumLeft == sum - sumLeft - nums[i]) {
                return i;
            }
            sumLeft += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = LeetCodeUtil.stringToIntegerArray(line);
            int ret = pivotIndex(nums);
            String out = String.valueOf(ret);
            System.out.print(out);
        }
    }
}