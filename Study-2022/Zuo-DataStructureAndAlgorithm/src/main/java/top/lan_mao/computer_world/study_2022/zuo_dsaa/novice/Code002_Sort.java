package top.lan_mao.computer_world.study_2022.zuo_dsaa.novice;

import java.util.Arrays;

/**
 * Copyright (c) 2019-present lan-mao.top
 * ComputerWorld is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at: <a href="http://license.coscl.org.cn/MulanPSL2">http://license.coscl.org.cn/MulanPSL2</a>
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 * <p>
 * Create Date 2022/08/05 7:27 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 * 选择排序 <br>
 */
public class Code002_Sort {

    public static void selectionSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int min = 0;
        for(int i =0; i<array.length; i++) {
            min = array[i];
            int t = i;
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    t = j;
                }
            }
            swapArray(array, i, t);
        }
    }

    public static void bubbleSort(int[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            boolean haveSwap = false;
            for (int i = 1; i <= end; i++) {
                if (array[i] < array[i - 1]) {
                    swapArray(array, i, i - 1);
                    haveSwap = true;
                }
            }
            if (!haveSwap) {
                return;
            }
        }
    }

    public static void insertSort(int[] array) {
        for (int end = 1; end < array.length; end++) {
            for (int point = end; point > 0 && array[point - 1] > array[point]; point--) {
                swapArray(array, point - 1, point);
            }
            /*
            第二种写法
            int i = point;
            while (i - 1 >= 0 && array[i] < array[i - 1]) {
                swapArray(array, i, --i);
            }*/
        }
    }

    public static void swapArray(int[] array, int i, int t) {
        if (t != i) {
            array[i] ^= array[t];
            array[t] ^= array[i];
            array[i] ^= array[t];
        }
    }

    public static int[] generateArray(int length, int max, int min) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)( Math.random() * max + min);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] a = generateArray(10000000, 100, 1);
        int[] b = {10, 100, 10};
        //System.out.println(Arrays.toString(a));
        //swapArray(b, 0, 0);
        //System.out.println(Arrays.toString(b));
        int[] c = Arrays.copyOf(a, a.length);
        int[] d = Arrays.copyOf(a, a.length);
        long timestamp1 = System.currentTimeMillis();
        selectionSort(a);
        long timestamp2 = System.currentTimeMillis();
        bubbleSort(c);
        long timestamp3 = System.currentTimeMillis();
        insertSort(d);
        long timestamp4 = System.currentTimeMillis();

        System.out.println(timestamp2 - timestamp1);
        System.out.println(timestamp3 - timestamp2);
        System.out.println(timestamp4 - timestamp3);
        //System.out.println(Arrays.toString(a));
        //System.out.println(Arrays.toString(c));
        //System.out.println(Arrays.toString(d));
    }
}