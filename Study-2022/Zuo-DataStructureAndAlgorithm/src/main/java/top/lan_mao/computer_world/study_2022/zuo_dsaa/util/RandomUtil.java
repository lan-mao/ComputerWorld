package top.lan_mao.computer_world.study_2022.zuo_dsaa.util;

/**
 * Copyright (c) 2019-present lan-mao.top
 * ComputerWorld is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at: <a href="http://license.coscl.org.cn/MulanPSL2">http://license.coscl.org.cn/MulanPSL2</a>
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 * <p>
 * Create Date 2022/08/06 18:30 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 * <br>
 */
public class RandomUtil {

    public static void main(String[] args) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int a = generateRandom(100, 10);
            if (a > 100 || a < 10) {
                System.out.println(a);
            }
        }
    }
    /**
     * 生成 在最大最小值中的数组
     */
    public static int[] generateArray(int length, int max, int min) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = generateRandom(max,min);
        }
        return array;
    }

    /**
     * 生成绝对值范围内的数组
     */
    public static int[] generateArray(int length, int range) {
        int[] temp = new int[length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = generateRandom(range);
        }
        return temp;
    }

    public static int generateRandom(int range) {
        double a = Math.random();
        double b = Math.random();
        return (int) (a * (range + 1)) - (int) (b * (range + 1));
    }


    public static int generateRandom(int max, int min) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }
}