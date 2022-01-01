package basic;

import java.util.ArrayList;
import java.util.Arrays;

public class Cygnus{
    static int value = 9; //注意value是静态的成员变量
    public static void main(String[] args) throws Exception{
        new Cygnus().printValue();
    }

    private void printValue(){
        int value = 69;
        System.out.println(this.value);
        Object obj;
        ArrayList arrayList;
        int[] arrays = new int[0];
        arrays.getClass();
        Arrays array;
    }
}

