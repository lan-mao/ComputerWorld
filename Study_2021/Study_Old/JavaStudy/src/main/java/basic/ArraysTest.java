package basic;

import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {
        Integer[] a = {1, 2,3,4,5,6,7};
        Integer[] b = Arrays.copyOf(a,10);
        System.out.println(Arrays.deepToString(b));
        deleteElement(a,2);
        System.out.println(Arrays.deepToString(a));
        Integer[] c = insertElement(a, 2, 8);
        System.out.println(Arrays.toString(c));
    }

    public static <T> void basicCopy(T[] src, int srcPos, T[] dest, int destPos, int length){
        System.arraycopy(src, srcPos, dest, destPos, length);
    }

    //删除一个数组元素，本质上还是数组的拷贝
    public static <T> void deleteElement(T[] src, int point){
        System.arraycopy(src, point+1, src, point, src.length-point-1);
        src[src.length-1] = null;
    }

    public static <T> T[] insertElement(T[] src, int point, T dest){
        T[]  s2 =(T[]) new Object[src.length+1];
        System.arraycopy(src, 0, s2, 0, point+1);
        s2[point] = dest;
        System.arraycopy(src, point, s2, point+1, src.length-point-1);
        return s2;
    }
    public static Integer[] insertElement(Integer[] src, int point, Integer dest){
        Integer[]  s2 = new Integer[src.length+1];
        System.arraycopy(src, 0, s2, 0, point+1);
        s2[point] = dest;
        System.arraycopy(src, point, s2, point+1, src.length-point-1);
        return s2;
    }

    public static <T> T[] extendRange(T[] src){
        T[] dest =(T[]) new Object[src.length+10];
        System.arraycopy(src, 0, dest, 0, src.length);
        return dest;
    }
}
