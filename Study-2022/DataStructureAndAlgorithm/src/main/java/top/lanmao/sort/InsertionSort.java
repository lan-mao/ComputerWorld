package top.lanmao.sort;

/**
 * Create Date 2021/01/14 21:40:49 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 插入排序算法 <br>
 */
public class InsertionSort {

    /**
     * 使用插入排序算法对数组进行排序，使用升序序列
     * @param a 传入的数组元数据
     */
    public static void insertionSortA(int[] a) {
        int num = 0;
        //使用从头到尾的查找方法
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            num++;
            for (int j = 0; j < i; j++) {
                if (a[i] < a[j]) {
                    for (int k = i; k > j; k--) {
                        a[k] = a[k-1];
                        num++;
                    }
                    a[j] = temp;
                    num++;
                    break;
                }
            }
        }
        System.out.println("操作次数：" + num);
    }

    public static void insertionSortB(int[] a) {
        int num = 0;
        //使用从尾到头的查找方法
        for (int i = 1; i < a.length; i++) {
            num++;
            int temp = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (temp < a[j]) {
                    a[j + 1] = a[j];
                    num++;
                } else {
                    break;
                }
            }
            a[j+1] = temp;
        }
        System.out.println("操作次数：" + num);
    }
    public static void insertionSortC(int[] a) {
        int num = 0;
        //使用从尾到头的查找方法
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            num++;
            for (int j = i - 1; j >= 0; j--) {
                //找到要插入的位置
                if (a[i] >= a[j] || j ==0) {
                    if (i != j +1) {
                        for (int k = i ; k > j; k--) {
                            a[k] = a[k-1];
                            num++;
                        }
                        int t = j == 0 && temp < a[j] ? 0 : j + 1;
                        a[t] = temp;
                    }
                    num++;
                    break;
                }
            }
        }
        System.out.println("操作次数：" + num);
    }

    /**
     * 将数组使用插入排序，从小到大排序，使用从尾到头的查找方式
     * @param arrays 传入的元数据
     */
    public static void insertionSort(int[] arrays) {
        //从第二位开始向后
        for (int i = 1; i < arrays.length; i++) {
            int temp = arrays[i];
            int j = i - 1;
            //从尾部开始查找
            for (; j >= 0; j--) {
                if (temp < arrays[j]) {
                    arrays[j + 1] = arrays[j];
                } else {
                    break;
                }
            }
            arrays[j + 1] = temp;
        }
    }
}