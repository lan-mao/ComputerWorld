package stream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Classname Copy
 * 写一个流与流的对接
 * @Date 2020/02/05 9:20
 * @Created by lan-mao.top
 */

public class Copy {
    public static void main(String[] args) {
        
    }
    
    public static void copy (InputStream inputStream, OutputStream outputStream){
        try (inputStream;outputStream){
            byte[] temp = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(temp))!= -1){
                outputStream.write(temp, 0, length);
            }
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
