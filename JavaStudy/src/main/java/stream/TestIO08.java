package stream;

import java.io.*;
import java.net.URL;

/**
 * @Classname TestIO08
 * 操作网络流，读取网络文字
 * @Date 2020/02/05 22:34
 * @Created by lan-mao.top
 */

public class TestIO08 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("https://www.baidu.com").openStream(), "GBK"));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))){
            String temp ;
            while ((temp = reader.readLine()) != null){
                writer.write(temp);
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
