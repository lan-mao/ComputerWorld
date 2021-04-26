package LeetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] digits = LeetCodeUtil.stringToIntegerArray(line);

            int[] ret = plusOne(digits);

            String out = LeetCodeUtil.integerArrayToString(ret);

            System.out.print(out);
        }
    }
}