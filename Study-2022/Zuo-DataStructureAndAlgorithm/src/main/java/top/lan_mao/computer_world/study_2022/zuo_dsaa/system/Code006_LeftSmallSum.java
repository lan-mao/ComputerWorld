package top.lan_mao.computer_world.study_2022.zuo_dsaa.system;

import top.lan_mao.computer_world.study_2022.zuo_dsaa.util.RandomUtil;

import java.util.Arrays;

/**
 * Copyright (c) 2019-present lan-mao.top
 * ComputerWorld is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at: <a href="http://license.coscl.org.cn/MulanPSL2">http://license.coscl.org.cn/MulanPSL2</a>
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 * <p>
 * Create Date 2022/09/18 16:39 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 * 数组中左边小于右边数的和
 * 如，[3,1,2,6,4]
 * 3：左边无比3小的
 * 1：左边无比1小的
 * 2：左边有1 sum=1
 * 6：左边有3，1，2 sum=7
 * 4：左边有3，1，2 sum=13<br>
 */

public class Code006_LeftSmallSum {

    public static void main(String[] args) {
        for (int i = 0 ; i < 100000; i++) {
            int[] list = RandomUtil.generateArray((int) (Math.random() * 1000), (int) (Math.random() * 1000));
            int[] temp = Arrays.copyOf(list, list.length);

            int a = leftSmallSum(list, 0, list.length - 1);
            int b = compareAlgorithm(temp);

            if (a != b) {
                System.out.println(Arrays.toString(temp));
                System.out.println(a + " " + b);
                break;
            }
        }
    }

    public static int compareAlgorithm(int[] list) {
        int sum = 0;
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < i; j++) {
                if (list[j] < list[i]) {
                    sum += list[j];
                }
            }
        }
        return sum;
    }

    public static int leftSmallSum(int[] list, int left, int right) {
        int sum = 0;
        if (left >= right) {
            return sum;
        }
        int middle = left + (right - left) / 2;
        sum += leftSmallSum(list, left, middle);
        sum += leftSmallSum(list, middle + 1, right);
        sum += merge(list, left, right, middle);
        return sum;
    }

    private static int merge(int[] list, int left, int right, int middle) {
        int sum = 0;
        int[] tempList = new int[right - left + 1];

        int pointLeft = left;
        int pointRight = middle + 1;
        int pointTemp = 0;

        while (pointLeft <= middle && pointRight <= right) {
            if (list[pointLeft] < list[pointRight]) {
                sum += list[pointLeft] * (right - pointRight + 1);
                tempList[pointTemp++] = list[pointLeft++];
            } else {
                tempList[pointTemp++] = list[pointRight++];
            }
        }
        while (pointLeft <= middle) {
            tempList[pointTemp++] = list[pointLeft++];
        }
        while (pointRight <= right) {
            tempList[pointTemp++] = list[pointRight++];
        }

        for (int i = left, j = 0; i <= right; i++, j++) {
            list[i] = tempList[j];
        }

        return sum;
    }
}