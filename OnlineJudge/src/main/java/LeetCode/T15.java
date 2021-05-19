package LeetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create Date 2021/05/02 7:37:51 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 三数之和 <br>
 */
public class T15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int index, leftIndex, rightIndex;
        Arrays.sort(nums);
        for (index = 0; index < nums.length; index++) {
            if (nums[index] > 0 ) {
                return result;
            }
            if (index == 0 || nums[index] != nums[index-1]) {
                leftIndex = index + 1;
                rightIndex = nums.length - 1;
                while (leftIndex < rightIndex) {
                    int sum = nums[index] + nums[leftIndex] + nums[rightIndex];
                    if (sum > 0) {
                        rightIndex--;
                    } else if (sum < 0) {
                        leftIndex++;
                    } else {
                        Integer[] integers = {nums[index], nums[leftIndex], nums[rightIndex]};
                        result.add(Arrays.asList(integers));
                        while (leftIndex < rightIndex && nums[leftIndex] == integers[1]) {
                            leftIndex++;
                        }
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = LeetCodeUtil.stringToIntegerArray(line);

            List<List<Integer>> ret = threeSum(nums);

            String out = LeetCodeUtil.int2dListToString(ret);

            System.out.println(out);
        }
    }
}