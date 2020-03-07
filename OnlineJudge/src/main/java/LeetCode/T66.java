package LeetCode;

import java.util.Arrays;

/**
 * @Classname T66
 * [加一]()
 * @Date 2020/02/06 21:25
 * @Created by lan-mao.top
 */

public class T66 implements Solution {
    public int[] plusOne(int[] digits) {
        int[] answer = {1};
        if (digits[0] == 0)
            return answer;
        boolean add = false;//记录是否需要进位
        if (++digits[digits.length-1] ==10){
            add = true;
            digits[digits.length-1] =0;
            for (int i = digits.length-2; i>=0; i--){
                if (add && ++digits[i] ==10){
                    add = true;
                    digits[i] = 0;
                }else {
                    add = false;
                    break;
                }
            }
        }
        if (add){
            answer = new int[digits.length+1];
            System.arraycopy(digits, 0, answer, 1, digits.length);
            answer[0] = 1;
            return answer;
        }
        return digits;
    }
    @Override
    public void solution(Object... param) {
        int[] digits = (int[]) param[0];
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    public static void main(String[] args) {
        LeetCodeUtil.rootIntArrays(new T66());
    }
}
