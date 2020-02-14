package LeetCode;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Classname LeetCodeUtil
 *
 * @Date 2020/02/06 20:53
 * @Created by lan-mao.top
 */

public class LeetCodeUtil {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }



    public static int[][] stringToInt2dArray(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
            return new int[0][0];
        }

        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void rootInt2dArrays (Solution solution)  {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = in.readLine()) != null) {
                int[][] matrix = stringToInt2dArray(line);
                solution.solution(matrix);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 用于需要输入int数组的方法
     * @param solution
     * @throws IOException
     */
    public static void rootIntArrays(Solution solution) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = in.readLine()) != null) {
                int[] nums = stringToIntegerArray(line);
                solution.solution(nums);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
interface Solution{
    /**
     * 运行输出操作
     * @param param 传入数组等内容，需要强制类型转换
     */
    void solution(Object... param);
}
