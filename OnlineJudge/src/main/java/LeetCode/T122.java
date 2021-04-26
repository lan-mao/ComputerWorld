package LeetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Create Date 2021/04/24 10:36:01 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 买卖股票的最佳时机 <br>
 */
public class T122 {

    /**
     * 初步思路：建立一个hashmap表，存储每次股票买卖对应的差值。思路错误
     * 通过图解，只需要在每次股价上升开始时买进，上升结束时卖出
     */
    public static int maxProfit(int[] prices) {
        //标识是否买入
        boolean buy = false;
        //记录买入的价格
        int buyPrice = prices[0];
        //记录余额
        int balance = 0;
        for (int i = 1; i < prices.length; i++) {
            if (!buy && prices[i] > prices[i - 1]) {
                buy = true;
                buyPrice = prices[i -1];
            } else if (buy && prices[i] < prices[i - 1]) {
                buy = false;
                balance += prices[i - 1] - buyPrice;
            }
        }
        if (buy) {
            balance += prices[prices.length -1] - buyPrice;
        }
        return balance;
    }

    /**
     * 对上面图解法进行算法细节优化
     */
    public static int maxProfitByOptimization(int[] prices) {
        int balance = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                balance += prices[i] - prices[i - 1];
            }
        }
        return balance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] prices = LeetCodeUtil.stringToIntegerArray(line);

            int ret = maxProfit(prices);

            String out = String.valueOf(ret);

            System.out.println(out);
        }
    }
}