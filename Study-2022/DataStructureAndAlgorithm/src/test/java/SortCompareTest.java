import cn.hutool.core.util.RandomUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import top.lanmao.sort.BubbleSort;
import top.lanmao.sort.InsertionSort;
import top.lanmao.sort.SelectionSort;

/**
 * Create Date 2021/01/30 15:55:18 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 各种算法之间比较 <br>
 */
public class SortCompareTest {
    static int[] array;
    static int length = 100000;
    static int[] arrayOfBubbleSorted;
    static int[] arrayOfInsertionSorted;
    static int[] arrayOfSelectionSorted;

    @BeforeAll
    static void beforeAll() {
        if (array == null || array.length == 0) {
            array = new int[length];
            for (int i = 0; i < array.length; i++) {
                array[i] = RandomUtil.randomInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }

        arrayOfBubbleSorted = new int[array.length];
        arrayOfInsertionSorted = new int[array.length];
        arrayOfSelectionSorted = new int[array.length];
        System.arraycopy(array, 0, arrayOfBubbleSorted, 0, array.length);
        System.arraycopy(array, 0, arrayOfInsertionSorted, 0, array.length);
        System.arraycopy(array, 0, arrayOfSelectionSorted, 0, array.length);
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

    @AfterAll
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
}