import cn.hutool.core.util.RandomUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import top.lan_mao.sort.BubbleSort;
import top.lan_mao.sort.InsertionSort;
import top.lan_mao.sort.MergeSort;
import top.lan_mao.sort.SelectionSort;

import java.util.Arrays;

/**
 * Create Date 2021/01/16 20:14:18 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 排序算法的单元测试 <br>
 */
public class SortTest {
    static int[] array;
    static int length = 100000;
    static int[] arrayOfBubbleSorted;
    static int[] arrayOfInsertionSorted;
    static int[] arrayOfSelectionSorted;

    //@BeforeAll
    static void beforeAll() {
        if (array == null || array.length == 0) {
            array = new int[length];
            for (int i = 0; i < array.length; i++) {
                array[i] = RandomUtil.randomInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }

        //arrayOfBubbleSorted = new int[array.length];
        //arrayOfInsertionSorted = new int[array.length];
        //arrayOfSelectionSorted = new int[array.length];
        //System.arraycopy(array, 0, arrayOfBubbleSorted, 0, array.length);
        //System.arraycopy(array, 0, arrayOfInsertionSorted, 0, array.length);
        //System.arraycopy(array, 0, arrayOfSelectionSorted, 0, array.length);
    }

    @Test
    @DisplayName("数组测试——测试三种排序算法时间差异")
    void testSort01() {
        //System.out.println(Arrays.toString(array));
        System.out.println(testBubbleSort());
        //System.out.println(Arrays.toString(arrayOfBubbleSorted));
        System.out.println(testInsertionSort());
        //System.out.println(Arrays.toString(arrayOfInsertionSorted));
        System.out.println(testSelectionSort());
        //System.out.println(Arrays.toString(arrayOfSelectionSorted));
    }

    //@Test
    //@DisplayName("冒泡排序算法测试")
    long testBubbleSort() {
        long startTime = System.currentTimeMillis();
        BubbleSort.bubbleSort(arrayOfBubbleSorted);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    //@Test
    //@DisplayName("插入排序算法测试")
    long testInsertionSort() {
        long startTime = System.currentTimeMillis();
        InsertionSort.insertionSort(arrayOfInsertionSorted);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    //@Test
    //@DisplayName("选择排序算法测试")
    long testSelectionSort() {
        long startTime = System.currentTimeMillis();
        SelectionSort.selectionsSort(arrayOfSelectionSorted);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    //@AfterAll
    public static void afterAll() {
        System.out.println(check(arrayOfBubbleSorted));
        System.out.println(check(arrayOfInsertionSorted));
        System.out.println(check(arrayOfSelectionSorted));
    }

    public static boolean check(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                return false;
            }
        }
        return true;
    }

    @Test
    @DisplayName("归并排序")
    void mergeSort() {
        int length = 10;
        int[] a = new int[length];
        for (int i = 0; i < a.length; i++) {
            a[i] = RandomUtil.randomInt(0, 100);
        }
        System.out.println(Arrays.toString(a));
        MergeSort.mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    @Test
    @DisplayName("归并排序的哨兵算法")
    void mergeSortByGuard() {
        int length = 10;
        int[] a = new int[length];
        for (int i = 0; i < a.length; i++) {
            a[i] = RandomUtil.randomInt(0, 100);
        }
        a[length-5] = a[length -4] = a[length - 3] = Integer.MAX_VALUE;

        System.out.println(Arrays.toString(a));
        MergeSort.mergeSortByGuard(a, 0, a.length -1);
        System.out.println(Arrays.toString(a));
    }
    @Test
    @DisplayName("归并排序的哨兵算法")
    void mergeSortByNoGuard() {
        int length = 10;
        int[] a = new int[length];
        for (int i = 0; i < a.length; i++) {
            a[i] = RandomUtil.randomInt(0, 100);
        }

        System.out.println(Arrays.toString(a));
        MergeSort.mergeSortByNoGuard(a, 0, a.length -1);
        System.out.println(Arrays.toString(a));
    }
}