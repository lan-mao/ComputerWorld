package top.lanmao.sort;

import java.util.Arrays;
import java.util.Stack;

/**
 * Create Date 2021/01/30 15:44:29 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 快速排序 <br>
 */
public class QuickSort {
    /**
     * 通过使用两个临时数组进行快排，比较占用内存
     * @param array
     * @param begin
     * @param end
     */
    public static void quickSortByTempArray(int[] array, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int pivot = array[end];
        int[] temp1 = new int[end - begin];
        int[] temp2 = new int[end - begin];
        int j =0, k =0;
        for (int i = begin; i < end; i++) {
            if (array[i] < pivot) {
                temp1[j++] = array[i];
            } else {
                temp2[k++] = array[i];
            }
        }
        System.arraycopy(temp1, 0, array, begin, j);
        array[j] = pivot;
        System.arraycopy(temp2, 0, array, j + 1, k);
        quickSortByTempArray(array, begin, j - 1);
        quickSortByTempArray(array, j + 1, end);
    }

    /**
     * 通过交换实现快排的原地排序，不占用太多内存
     * @param array
     * @param begin
     * @param end
     */
    public static void quickSortInPlace(int[] array, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int q = partitionInPlaceByFor(array, begin, end);
        quickSortInPlace(array, begin, q -1);
        quickSortInPlace(array, q + 1, end);
    }

    /**
     * 使用while语句的是我自己写的，使用for语句的是教程中的。
     * 我的思路是：先遍历找到一个比pivot点元素大的元素的下标i，从begin到i中一定都是比pivot点小的元素，然后从这个位置开始向后继续找比pivot点小元素，与之相交换。这样直到最终，可以将end点也交换到正确的位置。
     * 教程的思路是：先找到一个比pivot点元素小的j点，然后找比pivot点大的元素i点，将两者交换。这里j一定是大于等于i的。
     * @param array
     * @param begin
     * @param end
     * @return
     */
    private static int partitionInPlaceByWhile(int[] array, int begin, int end) {
        int pivot = array[end];
        int i = begin, j = begin;
        while (i < end && j < end) {
            while (array[i] < pivot && i < end) {
                i++;
            }
            if (i > j) {
                j = i;
            }
            while (array[j] >= pivot && j < end) {
                j++;
            }
            if (array[i] > pivot && array[j] <= pivot && i != j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        return i;
    }

    /**
     * 如何改进代码使得代码减去最后重复的交换操作？
     * @param array
     * @param begin
     * @param end
     * @return
     */
    private static int partitionInPlaceByFor(int[] array, int begin, int end) {
        int pivot = array[end];
        int i = begin;
        for (int j = begin; j <= end; j++) {
            if (array[j] <= pivot) {
                if (i == j) {
                    i++;
                } else {
                    int temp = array[i];
                    array[i++] = array[j];
                    array[j] = temp;
                }
            }
        }

        return i - 1;
    }

    /**
     * 查找第K大元素
     */
    public static int searchNoK(int k, int[] array, int begin, int end) {
        //数组区间中的最后一个元素是第index大元素
        int index = division(array, begin, end);
        int no = index + 1;
        if (no == k) {
            return array[index];
        } else if (no < k) {
            return searchNoK(k - no, array, index + 1, end);
        } else {
            return searchNoK(no - k, array, begin, index - 1);
        }
    }

    /**
     * 将数组中数据进行一次分区，返回分区后的中间坐标
     * 数组中数据将被分为大于等于最后一个元素，最后一个元素，小于最后一个元素
     * @param array 要分区的数组
     * @param begin 数组开始元素
     * @param end 数组结束元素
     * @return 分区后的中间坐标
     */
    private static int division(int[] array, int begin, int end) {
        int pivot = array[end];
        int i = begin;
        for (int j = begin; j <= end; j++) {
            if (array[j] >= pivot) {
                if (i == j) {
                    i++;
                } else {
                    int temp = array[i];
                    array[i++] = array[j];
                    array[j] = temp;
                }
            }
        }
        return i - 1;
    }

    /**
     * 使用栈替换递归
     * @param array 要排序的数组
     */
    public static void quickSortByNoRecursion(int[] array) {
        class Area {
            final int left, right;

            public Area(int left, int right) {
                this.left = left;
                this.right = right;
            }
        }
        Stack<Area> temp = new Stack<>();
        temp.push(new Area(0, array.length - 1));



        // 快排思想，需要三个指针，左指针找大于分割点的，直到找到大于分割点或位置与分割点相同；右指针找小于分割点的，直到找到小于分割点或位置等于左指针
        // 需要在栈中记录左右两区的边界，
        while (!temp.empty()) {

            Area pop = temp.pop();

            // 设置模拟递归结束条件
            if (pop.left >= pop.right) {
                continue;
            }

            int leftPoint = pop.left;
            int rightPoint = pop.right - 1;
            int splitPoint = pop.right;


            while (true) {
                System.out.println(Arrays.toString(array));
                while (array[leftPoint] <= array[splitPoint] && leftPoint < splitPoint) {
                    leftPoint++;
                }
                while (array[rightPoint] > array[splitPoint] && rightPoint > leftPoint) {
                    rightPoint++;
                }

                if (leftPoint < rightPoint) {
                    int swap = array[leftPoint];
                    array[leftPoint] = array[rightPoint];
                    array[rightPoint] = swap;
                } else if (leftPoint == rightPoint) {
                    int swap = array[leftPoint];
                    array[leftPoint] = array[splitPoint];
                    array[splitPoint] = swap;

                    temp.push(new Area(pop.left, leftPoint - 1));
                    temp.push(new Area(leftPoint + 1, pop.right));

                    break;
                } else if (leftPoint == splitPoint) {
                    // 此情况下除分割点位置之外，全部小于分割点
                    // 全部大于分割点的情况，作为上一个情况处理
                    temp.push(new Area(pop.left, pop.right - 1));
                    break;
                }
            }

        }

    }

}