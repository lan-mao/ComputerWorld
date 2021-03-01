package top.lan_mao.sort;

/**
 * Create Date 2021/01/31 11:38:57 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 桶排序 <br>
 *
 */
public class BucketSort {
    /**
     * 桶排序算法
     * @param array 数组
     * @param begin 数组开始下标
     * @param end 结束下标
     * @param bucketSize 桶容量
     */
    public static void bucketSort(int[] array, int begin, int end, int bucketSize) {
        int max = array[begin], min = array[begin];
        int length = end - begin + 1;
        if (length < 2) {
            return;
        }
        for (int i = begin; i <= end; i++) {
            if (max < array[i])
                max = array[i];
            if (min > array[i])
                min = array[i];
        }

        //桶数量
        //如果数据范围比数据数量小，那么不能让桶数量为0
        //这个式子将数据范围和数据数量都算在了一起
        int bucketCount = (max - min)/bucketSize + 1;
        int[][] bucket = new int[bucketCount][bucketSize];
        int[] bucketIndex = new int[bucketCount];

        for (int i = begin; i <= end; i++) {
            //放在哪个桶
            int index = (array[i] - min) / bucketSize;
            if (bucketIndex[index] == bucket[index].length) {
                //扩容
                bucket[index] = extend(bucket[index]);
            }
            bucket[index][bucketIndex[index]++] = array[i];
        }

        //进行快排
        int j = 0;
        for (int i = 0; i < bucketCount; i++) {
            quickSort(bucket[i], 0, bucketIndex[i] -1);
            System.arraycopy(bucket[i],0,array, j, bucketIndex[i]);
            j += bucketIndex[i];
        }
    }

    private static int[] extend(int[] array) {
        int length = array.length;
        int[] newArray = new int[length * 2];
        System.arraycopy(array, 0, newArray, 0, length);
        return newArray;
    }

    private static void quickSort(int[] array, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int pivot = array[end];
        int i = begin;
        for (int j = begin; j <= end; j++) {
            if (array[j] <= pivot) {
                if (i == j) {
                    i++;
                } else {
                    swapArray(array, i++, j);
                }
            }
        }
        quickSort(array, begin, i - 2);
        quickSort(array, i, end);
    }

    /**
     * 交换
     * @param array 交换的数组
     * @param i 交换坐标i
     * @param j 交换坐标j
     */
    private static void swapArray(int[] array, int i, int j) {
        if (i == j)
            return;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}