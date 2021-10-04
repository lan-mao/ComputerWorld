package top.lan_mao.javase.base;

import java.util.Arrays;

/**
 * Create Date 2021/01/10 12:03:45 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 冒泡排序 <br>
 */
public class BubblingSort {
    public static void main(String[] args) {
        int[] array = {1929,249,2444,5594,4,54,5,67,8788,100};
        bubbleSort(array, true);
        System.out.println(Arrays.toString(array));
        bubbleSort(array, false);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 使用冒泡排序，默认升序排列
     * @param array    输入数组
     * @param reversed 是否降序排列
     */
    public static void bubbleSort(int[] array, boolean reversed) {
        if (array != null && array.length >= 1) {
            int a = 0;
            do {
                a = 0;
                for (int i = 1; i < array.length; i++) {
                    //循环遍历数组中元素，并采用冒泡方式排序
                    //如果降序且当前元素小于上一个元素，或者升序且当前元素小于上一个元素，则交换两者
                    if ((reversed && array[i] > array[i - 1]) || (!reversed && array[i] < array[i - 1])){
                        int temp = array[i];
                        array[i] = array[i - 1];
                        array[i - 1] = temp;
                        a++;
                    }
                }
            }
            while (a > 0);
        }
    }
}
