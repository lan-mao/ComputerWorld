package top.lan_mao.sort;

/**
 * Create Date 2021/01/14 21:40:18 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 冒泡排序算法 <br>
 */
public class BubbleSort {
    public static void bubbleSort(int[] array) {
        //一次冒泡排序的界限
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }
}
