package LeetCode;

import java.io.IOException;

/**
 * @Classname T724
 * 寻找数组的中心索引
 * @Date 2020/02/06 20:15
 * @Created by lan-mao.top
 */

public class T724 implements Solution{

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum+=num;
        }
        int sumLeft = 0;
        int size = nums.length;
        for (int i =0;i < size; i++){
            if (sumLeft == sum - sumLeft - nums[i])
                return i;
            sumLeft += nums[i];
        }
        return -1;
    }

    @Override
    public void solution(Object... param) {
        int[] nums = (int[]) param[0];
        System.out.println(pivotIndex(nums));
    }

    public static void main(String[] args) throws IOException {
        LeetCodeUtil.rootIntArrays(new T724());
    }
}
