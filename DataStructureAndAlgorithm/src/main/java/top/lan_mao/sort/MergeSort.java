package top.lan_mao.sort;

/**
 * Create Date 2021/01/15 11:25:26 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 归并排序算法 <br>
 */
public class MergeSort {

    /**
     * 对数组范围内的数据进行排序
     * @param array 数组
     * @param begin 开始下标
     * @param end 结束下标
     */
    public static void mergeSort(int[] array, int begin, int end) {
        mergeSortRecursion(array, begin, end);
    }

    /**
     * 对数组范围内的数据进行排序，使用哨兵算法
     * @param array 数组
     * @param begin 开始下标
     * @param end 结束下标
     */
    public static void mergeSortByGuard(int[] array, int begin, int end) {
        mergeSortRecursionByGuard(array, begin, end);
    }
    /**
     * 对数组范围内的数据进行排序，使用改进的没有哨兵的算法
     * @param array 数组
     * @param begin 开始下标
     * @param end 结束下标
     */
    public static void mergeSortByNoGuard(int[] array, int begin, int end) {
        mergeSortRecursionByNoGuard(array, begin, end);
    }

    /**
     * 递归调用，将排序的数组分解并合并
     * @param array 要排序的数组
     * @param begin 开始的下标
     * @param end 结束的下标
     */
    private static void mergeSortRecursion(int[] array, int begin, int end) {
        if (begin >= end) {
            //分割结束，返回并排序
            return;
        }
        //中间分割的位置
        int center = (end + begin) / 2;
        mergeSortRecursion(array, begin, center);
        mergeSortRecursion(array, center + 1, end);
        merge(array, begin, end, center);
    }

    /**
     * 合并排序后的数组
     * @param array 排序后的数组
     * @param begin 合并的起始位置
     * @param end 合并的终点
     * @param center 分割位置
     */
    private static void merge(int[] array, int begin, int end, int center) {
        int length = end - begin + 1;
        int[] temp = new int[length];
        int i = begin;
        int j = center + 1;
        int k = 0;
        /*
         * 2021/1/29 029 这里如果使用或符号，可不可以将剩下的东西全部放入临时数组？
         * 分析：当将一个子数组全部放入时，其最后的最大元素一定小于剩余的那个子数组中的剩余元素。
         * 例如，当全完成的子数组为前面的数组时，i为center+1，此时j的数据一定大于等于i的数据。while执行的条件array[j] < array[i]便一定不成立。当全完成的子数组为后面的时，j=end+1，此时数据不能确定谁大谁小，且数组可能越界了，不能使用。
         */
        while (i <= center && j <= end) {
            while (i <= center && array[i] <= array[j]) {
                //当前面子数组的元素小于后面子数组的元素，将前面子数组的元素放入临时数组
                //相等的元素为保证算法的稳定性，优先放入前面数组的元素
                temp[k++] = array[i++];
            }
            while (j <= end && array[j] < array[i]) {
                temp[k++] = array[j++];
            }
        }
        int a, b;
        if (i <= center) {
            a = i;
            b = center;
        } else {
            a = j;
            b = end;
        }
        for (; a <= b; a++) {
            temp[k++] = array[a];
        }
        System.arraycopy(temp, 0, array, begin, length);
    }

    /**
     * 递归调用，将排序的数组分解并合并
     * @param array 要排序的数组
     * @param begin 开始的下标
     * @param end 结束的下标
     */
    private static void mergeSortRecursionByGuard(int[] array, int begin, int end) {
        if (begin >= end) {
            //分割结束，返回并排序
            return;
        }
        //中间分割的位置
        int center = (end + begin) / 2;
        mergeSortRecursionByGuard(array, begin, center);
        mergeSortRecursionByGuard(array, center + 1, end);
        mergeByGuard(array, begin, end, center);
    }
    /**
     * 使用哨兵的方法
     * @param array
     * @param begin
     * @param end
     * @param center
     */
    private static void mergeByGuard(int[] array, int begin, int end, int center) {
        /*
         * 如何将子数组在同一个while代码中完成，如果放入哨兵呢？
         *  分析：可以将最大值当哨兵。当将哨兵放入每个子数组的最后一位之后时，此时的完成的子数组为前面的或者后面的时，都为哨兵所在的下标，都不会越界，且一定能够保证剩下的子数组的数据小于等哨兵值。
         *  此时需要注意的是，需要小心当前数组中是否会有最大值的元素。不，此时应该是以下标位置作为判断条件的
         */
        int guard = Integer.MAX_VALUE;
        int length = end - begin + 1;
        int[] temp = new int[length + 2];

        int begin1 = 0;
        int length1 = center - begin + 1;
        int end1 = begin1 + length1;

        int begin2 = end1 + 1;
        int length2 = end - center;
        int end2 = begin2 + length2;

        //放入哨兵
        System.arraycopy(array, begin, temp, begin1, length1);
        temp[end1] = guard;
        System.arraycopy(array, center + 1, temp, begin2, length2);
        temp[end2] = guard;

        int i = begin1;
        int j = begin2;
        int k = begin;
        /*
        必须要保证将数组中与哨兵元素相等的元素也可以放入，则：
            1. 在循环的条件判断中，必须是或语句，否则循环可能无法进行完全
            2. 必须要保证相同的元素，在原顺序中的相对位置保持不变，则前面子数组下标对应值肯定为哨兵的小值或等值，
            3. 后面子数组下标对应值如果是哨兵值则必须在前面子数组进行完成后在插入
            4. 不管怎样循环，下标必须有一个界限
         */
        while (i < end1 || j < end2) {
            while ((temp[i] <= temp[j] && i < end1) || (temp[i] == guard && i < end1 && temp[i] <= temp[j])) {
                array[k++] = temp[i++];
            }
            while ((temp[j] < temp[i] && j < end2) || (temp[j] == guard && j < end2 && i == end1 )) {
                array[k++] = temp[j++];
            }
        }
    }

    /**
     * 递归调用，将排序的数组分解并合并
     * @param array 要排序的数组
     * @param begin 开始的下标
     * @param end 结束的下标
     */
    private static void mergeSortRecursionByNoGuard(int[] array, int begin, int end) {
        if (begin >= end) {
            //分割结束，返回并排序
            return;
        }
        //中间分割的位置
        int center = (end + begin) / 2;
        mergeSortRecursionByNoGuard(array, begin, center);
        mergeSortRecursionByNoGuard(array, center + 1, end);
        mergeByNoGuard(array, begin, end, center);
    }

    /**
     * 尝试不使用哨兵，通过条件判断简化代码
     * @param array 排序后的数组
     * @param begin 合并的起始位置
     * @param end 合并的终点
     * @param center 分割位置
     */
    private static void mergeByNoGuard(int[] array, int begin, int end, int center) {
        int length = end - begin + 1;
        int[] temp = new int[length];
        int i = begin;
        int j = center + 1;
        int k = 0;
        /*
        如果通过条件判断来使得所有的赋值操作在一次性中完成，则：
            1. while的条件循环判断必须是”或“语句，否则当一个子数组完成时，剩余的那个数组就有可能不再进行循环了
            2. 当其中一个子数组完成时，那么剩余的子数组元素一定是大于等于完成的子数组最后一个元素，但此时的完成子数组浮标肯定已经越界，可以通过判断浮标是否越界来确定另一个子数组是否完成
            3. 下标必须要有一个界限
         */
        while (i <= center || j <= end) {
            while ((i <= center && array[i] <= array[j]) || (j > end && i <= center)) {
                //当前面子数组的元素小于后面子数组的元素，将前面子数组的元素放入临时数组
                //相等的元素为保证算法的稳定性，优先放入前面数组的元素
                temp[k++] = array[i++];
            }
            while ((j <= end && array[j] < array[i]) || (i > center && j <= end)) {
                temp[k++] = array[j++];
            }
        }
        System.arraycopy(temp, 0, array, begin, length);
    }

}