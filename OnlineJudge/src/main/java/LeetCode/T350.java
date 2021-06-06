package LeetCode;

import LeetCode.utill.LeetCodeUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Create Date 2021/04/22 18:35:10 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 350. 两个数组的交集Ⅱ <br>
 */
public class T350{
    public int[] intersect(int[] nums1, int[] nums2) {
        int length = 0;
        for (int k : nums1) {
            for (int j = length; j < nums2.length; j++) {
                if (k == nums2[j]) {
                    int temp = nums2[length];
                    nums2[length] = nums2[j];
                    nums2[j] = temp;
                    length++;
                    break;
                }
            }
        }
        int[] result = new int[length];
        System.arraycopy(nums2, 0, result, 0, length);
        return result;
    }

    /**
     * 使用HashMap记录每个记录出现的次数，再一一匹配
     * 此方法的时间复杂度为O(n+m)
     */
    public int[] intersectByHashMap(int[] nums1, int[] nums2) {
        //这里的用来确定创建的HashMap的空间大小较小
        if (nums1.length > nums2.length) {
            return intersectByHashMap(nums2, nums1);
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums1.length);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : nums1) {
            int num = 1;
            if (hashMap.containsKey(i)){
                num = hashMap.get(i) + 1;
            }
            hashMap.put(i, num);
        }
        int[] result = new int[nums1.length];
        int index = 0;
        for (int i : nums2) {
            if (hashMap.containsKey(i)) {
                int num = hashMap.get(i) - 1;
                result[index++] = i;
                if (num > 0) {
                    hashMap.put(i, num);
                } else {
                    hashMap.remove(i);
                }
            }
        }
        return Arrays.copyOf(result, index);
    }

    /**
     * 首先进行两个数组的排序，然后进行依次遍历
     */
    public int[] intersectBySort(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0, index2 = 0;
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int num = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] > nums2[index2]) {
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] == nums2[index2]){
                result[num++] = nums1[index1];
                index1++;
                index2++;
            }
        }
        return Arrays.copyOf(result, num);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums1 = LeetCodeUtil.stringToIntegerArray(line);
            line = in.readLine();
            int[] nums2 = LeetCodeUtil.stringToIntegerArray(line);

            int[] ret = new T350().intersectByHashMap(nums1, nums2);

            String out = LeetCodeUtil.integerArrayToString(ret);

            System.out.print(out);
        }
    }

}