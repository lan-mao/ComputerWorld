package stream;

import java.io.*;
import java.util.Arrays;

/**
 * @Classname TestIO
 *  测试IO流的使用方法
 * @Date 2020/02/04 11:41
 * @Created by lan-mao.top
 */

public class TestIO {
    public static void main(String[] args) {
        File src = new File("images/abs.txt");
        if (!src.exists()){
            try {
                src.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(src.getAbsolutePath());
        //File classFile = new File(TestIO.class.getResource("").getPath());
        //System.out.println(Arrays.toString(classFile.list()));

        File parentFile = src.getParentFile();
        System.out.println(parentFile.getAbsolutePath());
        System.out.println(Arrays.toString(parentFile.list()));

        //try (InputStream input = new FileInputStream(src);){
        //    int temp ;
        //    while ( (temp=input.read()) != -1){
        //        System.out.println((char)temp);
        //    }
        //} catch (FileNotFoundException e) {
        //    e.printStackTrace();
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
    }
}
