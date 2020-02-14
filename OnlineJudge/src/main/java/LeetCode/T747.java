package LeetCode;

/**
 * @Classname T747
 * 至少是其他数字两倍的最大数
 * @Date 2020/02/06 20:51
 * @Created by lan-mao.top
 */

public class T747 implements Solution{
    public int dominantIndex(int[] nums) {
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
    @Override
    public void solution(Object... param) {
        int[] nums = (int[]) param[0];
        System.out.println(dominantIndex(nums));
    }

    public static void main(String[] args) {
        LeetCodeUtil.rootIntArrays(new T747());
    }
}
