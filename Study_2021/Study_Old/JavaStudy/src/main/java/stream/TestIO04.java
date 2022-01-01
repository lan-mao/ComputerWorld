package stream;

import java.io.*;

/**
 * @Classname TestIO04
 *  使用文件字符流
 * @Date 2020/02/04 19:51
 * @Created by lan-mao.top
 */

public class TestIO04 {
    public static void main(String[] args) {
        File file = new File("dest.txt");

        try (FileWriter writer = new FileWriter(file);
             Reader reader = new FileReader(file);) {
            String str = "qwertyuiop[]\\asdfghjkl;'zxcvbnm,./1234567890-=!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:\"ZXCVBNM<>?\n";
            for (int i = 0; i < 100; i++) {
                writer.append(str);
            }
            writer.flush();
            StringBuilder text = new StringBuilder();
            char[] temp = new char[1024*10];
            int length = 0;
            while ((length = reader.read(temp)) != -1){
                text.append(temp, 0, length);
            }
            System.out.println(text.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
