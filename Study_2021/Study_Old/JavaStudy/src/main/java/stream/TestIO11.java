package stream;

import java.io.*;

/**
 * @Classname TestIO11
 * 实验PrintStream
 * @Date 2020/02/06 10:02
 * @Created by lan-mao.top
 */

public class TestIO11 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream print = System.out;
        print.println("system.out");
        //将System.out重定向至文件
        print = new PrintStream(new BufferedOutputStream(new FileOutputStream("print_stream.txt")), true);
        System.setOut(print);
        System.out.println("我在文件");
        //将System.out重定向至标准输出端（控制台）
        print = new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)), true);
        System.setOut(print);
        System.out.println("我在控制台");
    }
}
