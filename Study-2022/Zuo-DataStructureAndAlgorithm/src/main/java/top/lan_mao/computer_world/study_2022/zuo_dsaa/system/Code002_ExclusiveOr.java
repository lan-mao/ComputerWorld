package top.lan_mao.computer_world.study_2022.zuo_dsaa.system;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Copyright (c) 2019-present lan-mao.top
 * ComputerWorld is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at: <a href="http://license.coscl.org.cn/MulanPSL2">http://license.coscl.org.cn/MulanPSL2</a>
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 * <p>
 * Create Date 2022/08/08 15:59 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 * 异或操作 <br>
 */
public class Code002_ExclusiveOr {
    public static void main(String[] args) {
        // 生成多少种数
        int type = 100;
        // 生成数的绝对值范围
        int range = 200;
        // 生成数出现的最大次数
        int timeMax = 9;
        // 测试次数
        int frequency = 100000;

        for (int i = 0; i < frequency; i++) {
            int t1 = (int) (Math.random() * timeMax) + 1;
            int t2 = (int) (Math.random() * timeMax) + 1;
            if (t1 == t2) {
                t2 ++;
            }
            int k = Math.min(t1, t2);
            int m = Math.max(t1, t2);

            int[] array = generateArray(type, range, k, m);
            int a = findTheNumberOfK(array, k, m);
            int b = testFindTheNumberOfK(array, k, m);
            if (a != b || a != array[0]) {
                System.out.println("出错");
                System.out.println(Arrays.toString(array));
                System.out.println(k + " " + m);
                System.out.println(a);
                System.out.println(b);
                break;
            }

        }
    }

    public static int[] generateArray(int type, int range, int k, int m) {
        int length = k + m * (type - 1);
        int numK = generateRandom(range);
        int[] array = new int[length];

        int index = 0;
        for (; index < k; index++) {
            array[index] = numK;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < type; i++) {
            int random = generateRandom(range);
            if (random == numK || set.contains(random)) {
                i--;
            } else {
                set.add(random);
                for (int j = 0; j < m; j++) {
                    array[index++] = random;
                }
            }
        }

        // 打乱数组

        for (int i = 1; i < length; i++) {
            int ranIndex = (int) (Math.random() * (length - 1)) + 1;
            int temp = array[i];
            array[i] = array[ranIndex];
            array[ranIndex] = temp;
        }

        return array;
    }

    public static int generateRandom(int range) {
        return (int)(Math.random() * (range + 1)) - (int)(Math.random() * (range + 1));
    }

    /**
     * 数组中只有两个数出现奇数次，其余数都出现了偶数次，找到这两个数
     */
    public static int[] printOddNumberTwo(int[] array) {
        int[] result = new int[2];

        int eor = 0;
        for (int j : array) {
            eor ^= j;
        }

        // 找到异或结果的二进制中的一个 1 。选最右侧。
        // 因为异或结果代表最后两个数 a ^ b;如果为1，说明此位置上两数不相同
        int rightOne = eor & (-eor);
        int eor_ = 0;

        for (int i : array) {
            if ((rightOne & i) != 0) {
                eor_ ^= i;
            }
        }

        result[0] = eor_;
        result[1] = eor ^ eor_;

        return result;
    }

    /**
     * 一个数组中，有且仅有一个数出现了K次，其余都出现了M次。找到这个K次的数。
     * 其中：
     * K < M
     * M > 1
     */
    public static int findTheNumberOfK(int[] array, int k, int m) {
        int[] temp = new int[32];

        for (int num : array) {
            for (int i = 0; i < temp.length; i++) {
                //if (((num >> i) & 1) != 0) {
                //    temp[i] ++;
                //}
                temp[i] += (num >> i) & 1;
            }
        }

        int result =  0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] % m != 0) {
                //result += 1 << i;
                result |= 1 << i;
            }
        }
        return result;
    }

    public static int testFindTheNumberOfK(int[] array, int k, int m) {
        HashMap<Integer, Integer> temp = new HashMap<>();
        for (int a : array) {
            if (temp.containsKey(a)) {
                temp.put(a, temp.get(a) + 1);
            } else {
                temp.put(a, 1);
            }
        }

        for (int a: temp.keySet()) {
            if (temp.get(a) == k) {
                return a;
            }
        }

        return -1;
    }

}