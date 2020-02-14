package stream;

import java.io.*;

/**
 * @Classname TestIO02
 *  文件的拷贝
 * @Date 2020/02/04 17:43
 * @Created by lan-mao.top
 */

public class TestIO03 {
    public static void main(String[] args) {
        File fileInput = new File("D:\\Source\\Video\\Linux就该这么学（16期）\\第1节课.mp4");
        File fileOutput = new File("copy.mp4");
        try (OutputStream outputStream = new FileOutputStream(fileOutput);
                InputStream inputStream = new FileInputStream(fileInput)){
            byte[] temp = new byte[1024];
            int length ;
            long begin = System.currentTimeMillis();
            while ((length = inputStream.read(temp)) != -1){
                outputStream.write(temp);
                //outputStream.flush();
            }
            outputStream.flush();
            long end = System.currentTimeMillis();
            long time = end - begin;
            System.out.println(time + "毫秒");
            System.out.println(time/1000.0 + "秒");
            System.out.println(time/1000.0/60 + "分");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
