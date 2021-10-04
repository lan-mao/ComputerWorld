package stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname TestIO05
 *  字节数组流测试
 * @Date 2020/02/05 8:00
 * @Created by lan-mao.top
 */

public class TestIO05 {
    public static void main(String[] args) {
        //从内存中读取数据
        byte[] src = "talk is cheap show me the code".getBytes();
        try(InputStream inputStream = new ByteArrayInputStream(src)) {
            byte[] flush = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(flush)) != -1){
                System.out.println(new String(flush, 0, length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //向内存中写入数据
        byte[] dest = null;
        String str = "talk is cheap show me the code";
        byte[] temp = str.getBytes();
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();){
            outputStream.write(temp);
            outputStream.flush();
            dest = outputStream.toByteArray();
            System.out.println(new String(dest));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
