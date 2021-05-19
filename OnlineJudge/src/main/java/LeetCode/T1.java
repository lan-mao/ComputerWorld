package LeetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import static LeetCode.LeetCodeUtil.stringToIntegerArray;

/**
 * Create Date 2021/04/29 21:41:38 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 两数之和 <br>
 */
public class T1 {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public static int[] twoSumByHash(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int balance = target - nums[i];
            if (map.containsKey(balance)) {
                Integer index = map.get(balance);
                if (index != i) {
                    result[0] = i;
                    result[1] = index;
                    return result;
                }
            }
        }
        return result;
    }

    public static int[] twoSumByHashSecond(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int balance = target - nums[i];
            if (map.containsKey(balance)) {
                Integer index = map.get(balance);
                return new int[]{index, i};
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            int[] ret = twoSum(nums, target);

            String out = LeetCodeUtil.integerArrayToString(ret);

            System.out.print(out);
        }
    }
}