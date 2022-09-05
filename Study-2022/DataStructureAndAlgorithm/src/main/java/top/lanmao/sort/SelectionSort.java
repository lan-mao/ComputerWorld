package top.lanmao.sort;

/**
 * Create Date 2021/01/14 21:41:18 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 选择排序算法 <br>
 */
public class SelectionSort {
    public static void selectionsSort(int[] array) {
        //从头开始寻找最小值
        for (int i = 0; i < array.length; i++) {
            //最小值的位置
            int t = i;
            //最小值
            int min = array[i];
            for (int j = i; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    t = j;
                }
            }
            if (t != i) {
                int temp = array[i];
                array[i] = array[t];
                array[t] = temp;
            }
        }
    }
}