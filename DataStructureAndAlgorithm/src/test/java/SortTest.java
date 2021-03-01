import cn.hutool.core.util.RandomUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import top.lan_mao.sort.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Create Date 2021/01/16 20:14:18 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 排序算法的单元测试 <br>
 */
public class SortTest {


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
        MergeSort.mergeSortByNoGuard(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    @Test
    @DisplayName("快速排序算法")
    void quickSortByInPlace() {
        int length = 10;
        //int[] a = new int[length];
        //for (int i = 0; i < a.length; i++) {
        //    a[i] = RandomUtil.randomInt(0, 100);
        //}
        int[] a = {99, 100, 21, 8, 9, 88, 96, 61, 87, 88};
        System.out.println(Arrays.toString(a));
        QuickSort.quickSortInPlace(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    @Test
    @DisplayName("查找第K大元素")
    void searchNoK() {
        int length = 10;
        int[] a = new int[length];
        for (int i = 0; i < a.length; i++) {
            a[i] = RandomUtil.randomInt(0, 100);
        }
        //int[] a = {99, 100, 21, 8, 9, 88, 96, 61, 87, 88};
        System.out.println(Arrays.toString(a));
        System.out.println(QuickSort.searchNoK(5, a, 0, a.length - 1));
        System.out.println(Arrays.toString(a));
    }
    @Test
    @DisplayName("桶排序测试")
    void bucketSort() {
        int length = 10;
        int[] a = new int[length];
        for (int i = 0; i < a.length; i++) {
            a[i] = RandomUtil.randomInt(0, 100);
        }
        //int[] a = {99, 100, 21, 8, 9, 88, 96, 61, 87, 88};
        System.out.println(Arrays.toString(a));
        BucketSort.bucketSort(a, 0, length -1, 3);
        System.out.println(Arrays.toString(a));
    }
    @Test
    @DisplayName("计数排序测试")
    void countingSort() {
        int length = 100;
        int[] a = new int[length];
        for (int i = 0; i < a.length; i++) {
            a[i] = RandomUtil.randomInt(0, 100);
        }
        //int[] a = {99, 100, 21, 8, 9, 88, 96, 61, 87, 88};
        System.out.println(Arrays.toString(a));
        CountingSort.countingSort(a, 0, length -1);
        System.out.println(Arrays.toString(a));
    }
    @Test
    @DisplayName("基数排序测试")
    void radixSort() {
        int length = 100;
        int[] a = new int[length];
        for (int i = 0; i < a.length; i++) {
            a[i] = RandomUtil.randomInt(0, 10000);
        }
        //int[] a = {99, 100, 21, 8, 9, 88, 96, 61, 87, 88};
        System.out.println(Arrays.toString(a));
        RadixSort.radixSort(a, 0, length -1);
        System.out.println(Arrays.toString(a));
    }

    @Test
    @DisplayName("测试Java原有的排序算法")
    void sortTests() {
        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();
        Object[] array = new Object[100];
        Arrays.sort(array);
        arrayList.sort();
        String a = new String();
        StringTokenizer stringTokenizer = new StringTokenizer("");

    }

}