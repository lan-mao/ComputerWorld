package stream;

import java.io.*;

/**
 * @Classname TestIO07
 * 字符缓冲流和转换流
 * @Date 2020/02/05 15:08
 * @Created by lan-mao.top
 */

public class TestIO07 {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));) {
            String temp = null;
            while ((temp = reader.readLine()) != null && !"exit".equals(temp)){
                writer.write(temp);
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
