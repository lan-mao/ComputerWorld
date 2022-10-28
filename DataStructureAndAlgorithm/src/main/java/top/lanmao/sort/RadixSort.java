package top.lanmao.sort;

/**
 * Create Date 2021/02/02 8:47:16 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 基数排序 <br>
 */
public class RadixSort {
    /**
     * 基数排序
     *
     * @param array 数据
     * @param begin 开始坐标
     * @param end   结束坐标
     */
    public static void radixSort(int[] array, int begin, int end) {
        if (begin >= end)
            return;
        int max = array[begin];
        int length = end - begin + 1;
        for (int i = begin; i <= end; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        for (int i = 1; max / i > 0; i *= 10) {
            countingSort(array, begin, end, i);
        }
    }

    /**
     * 通过计数排序对数组排序
     * @param array 数组
     * @param exp   排序的位（10的指数，用于得到用于排序的位）
     */
    private static void countingSort(int[] array, int begin, int end, int exp) {
        int length = end - begin + 1;
        int[] temp = new int[length];
        int[] indexes = new int[10];

        for (int i = begin; i <= end; i++) {
            indexes[array[i] / exp % 10] ++;
        }
        int sum = 0;
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = (sum += indexes[i]);
        }

        for (int i = end; i >= begin; i--) {
            temp[--indexes[array[i] / exp % 10]] = array[i];
        }

        System.arraycopy(temp, 0, array, begin, length);
    }
}