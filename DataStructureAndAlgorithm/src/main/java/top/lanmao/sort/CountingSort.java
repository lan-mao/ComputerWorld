package top.lanmao.sort;

/**
 * Create Date 2021/02/02 8:46:48 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 计数排序 <br>
 */
public class CountingSort {
    public static void countingSort(int[] array, int begin, int end) {
        if (begin >= end)
            return;
        int max = array[begin], min = array[begin];
        int length = end - begin + 1;
        for (int i = begin; i <= end; i++) {
            if (array[i] < min)
                min = array[i];
            if (array[i] > max)
                max = array[i];
        }
        int size = max - min + 1;
        int[] indexes = new int[size];
        int[] temp = new int[length];
        for (int i = begin; i <= end; i++) {
            indexes[array[i] - min] ++;
        }

        int sum = 0;
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = (sum += indexes[i]);
        }

        for (int i = end; i >= begin; i--) {
            temp[--indexes[array[i]-min]] = array[i];
        }
        System.arraycopy(temp, 0, array, begin, length);
    }
}