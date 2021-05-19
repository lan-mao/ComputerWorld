package LeetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author lan-mao.top
 * [加一]()
 */

public class T66 {
    public static int[] plusOne(int[] digits) {
        int[] answer = {1};
        if (digits[0] == 0) {
            return answer;
        }
        //记录是否需要进位
        boolean add = false;
        int singleMax = 10;
        if (++digits[digits.length-1] ==singleMax){
            add = true;
            digits[digits.length-1] =0;
            for (int i = digits.length-2; i>=0; i--){
                if (++digits[i] == 10){
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

    public static int[] plusOneSecond(int[] digits) {
        int[] result;
        if (digits[0] == 9) {
            result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
        } else {
            result = digits;
        }
        //表示下一个增加的值
        for (int index = result.length -1; index >= 0; index--) {
            int answer = ++result[index];
            if (answer == 10) {
                result[index] = 0;
            } else {

                break;
            }
        }
        if (result[0] == 0) {
            return Arrays.copyOfRange(result, 1, result.length);
        } else {
            return result;
        }
    }

    public static int[] plusOneThird(int[] digits) {
        for (int index = digits.length - 1; index >= 0; index--) {
            digits[index]++;
            digits[index] %= 10;
            if (digits[index] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        return digits;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] digits = LeetCodeUtil.stringToIntegerArray(line);

            int[] ret = plusOne(digits);

            String out = LeetCodeUtil.integerArrayToString(ret);

            System.out.println(out);
        }
    }
}