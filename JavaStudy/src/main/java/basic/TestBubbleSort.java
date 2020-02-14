package basic;

import java.util.Arrays;

public class TestBubbleSort {
    public static void main(String[] args) {
        int[] values = {3,2,5,6,7,9,1,8,43,2,5,6,7,9,1,8,4,6,7,9,11,8,41,8,43,2,5,6,7,9,1,8,4,6,7,9,11,8,4,6,7};
        int num = 0;
        for (int j = values.length - 1; j>0;j--) {
            boolean change = false;
            for (int i = 0; i < j; i++) {
                if (values[i] > values[i + 1]) {
                    int a = values[i];
                    values[i] = values[i + 1];
                    values[i + 1] = a;
                    change = true;
                }
                if (values[i] == values[i+1]){
                    values[i] = 0;
                }
                num ++;
                System.out.println(num + "-" + Arrays.toString(values));
            }
            System.out.println("###########################");
            if (!change) break;
        }
    }
}
