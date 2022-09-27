package top.lan_mao.computer_world.study_2022.zuo_dsaa.system;

import java.util.Arrays;

/**
 * Copyright (c) 2019-present lan-mao.top
 * ComputerWorld is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at: <a href="http://license.coscl.org.cn/MulanPSL2">http://license.coscl.org.cn/MulanPSL2</a>
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 * <p>
 * Create Date 2022/09/06 19:42 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 * 归并排序 <br>
 */

public class Code006_MergeSort {

    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 0; i < 100000; i++) {
            int length = (int) (Math.random() * 10000);
            int[] temp = generateArray(length, 10000);
            int[] temp2 = Arrays.copyOf(temp, temp.length);

            long timestamp1 = System.currentTimeMillis();
            mergeSortByIteration(temp);
            long timestamp2 = System.currentTimeMillis();
            mergeSortByRecursion(temp2, 0, length - 1);
            //bubbleSort(temp2);
            long timestamp3 = System.currentTimeMillis();

            if ((timestamp3 - timestamp2) < (timestamp2 - timestamp1)) {
                a++;
            }
            if ((timestamp3 - timestamp2) > (timestamp2 - timestamp1)) {
                b++;
            }
            if ((timestamp3 - timestamp2) == (timestamp2 - timestamp1)) {
                c++;
            }


            for (int j = 0; j < temp.length; j++) {
                if (temp[j] != temp2[j]) {
                    System.out.println(Arrays.toString(temp));
                    System.out.println(Arrays.toString(temp2));
                    return;
                }
            }
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

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

    public static void mergeSortByRecursion(int[] list, int start, int end) {
        if (start >= end) {
            return;
        }
        int point = start + (end - start) / 2;
        mergeSortByRecursion(list, start, point);
        mergeSortByRecursion(list, point + 1, end);

        merge(list, start, end, point);
    }

    private static void merge(int[] list, int start, int end, int middle) {
        int[] temp = new int[end - start + 1];

        int pointLeft = start;
        int pointRight = middle + 1;
        int pointTemp = 0;

        while (pointLeft <= middle && pointRight <= end) {
            temp[pointTemp++] =
                    list[pointLeft] <= list[pointRight] ? list[pointLeft++] : list[pointRight++];
        }
        while (pointLeft <= middle) {
            temp[pointTemp++] = list[pointLeft++];
        }
        while (pointRight <= end) {
            temp[pointTemp++] = list[pointRight++];
        }

        int pointTemp1 = 0;
        int pointTemp2 = start;
        while (pointTemp1 < temp.length) {
            list[pointTemp2++] = temp[pointTemp1++];
        }
    }

    public static void bubbleSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int second = 0;
            for (int j = 1; j < list.length - i; j++) {
                if (list[j] < list[j - 1]) {
                    int temp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = temp;
                    second++;
                }
            }
            if (second == 0) {
                break;
            }
        }
    }

    /**
     * 不使用递归方式
     * 使用步长代替递归的数组变化
     */
    public static void mergeSortByIteration(int[] list) {
        for (int step = 1; step < list.length; step <<= 1) {
            /*
            * 这是我自己写的代码
            int left = 0;
            int right = 0;
            int middle = 0;
            // 此处减一，代表如果剩下的数只能有左部分，则舍弃
            do {
                // 此处减一是因为left本身也算在了范围里面
                merge(list, left, right, middle);
                if (right != 0) {
                    left = right + 1;
                }
                right = left + step * 2 - 1;
                if (right > list.length - 1) {
                    right = list.length - 1;
                }
                middle = left + step - 1;
            }while (middle < list.length - 1);*/

            int left = 0;
            while (left < list.length) {
                int middle = left + step - 1;
                if (middle >= list.length - 1) {
                    break;
                }
                int right = Math.min(list.length - 1, middle + step);
                merge(list, left, right, middle);
                left = right + 1;
            }

            // 此处的限定是防溢出
            if (step > list.length / 2) {
                break;
            }
        }
    }
}