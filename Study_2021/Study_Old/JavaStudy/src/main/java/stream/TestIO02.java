package stream;

import java.io.*;

/**
 * @Classname TestIO02
 *  文件字节流
 * @Date 2020/02/04 17:43
 * @Created by lan-mao.top
 */

public class TestIO02 {
    public static void main(String[] args) {
        //File fileInput = new File("dest3.txt");
        //
        //try (OutputStream outputStream = new FileOutputStream(fileInput,true);){
        //    String string = "IO Test NO1\r\n";
        //    byte[] bytes = string.getBytes();
        //    outputStream.write(bytes);
        //    outputStream.flush();
        //} catch (FileNotFoundException e) {
        //    e.printStackTrace();
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
        //try (InputStream inputStream = new FileInputStream(fileInput);){
        //    //inputStream.mark(Integer.MAX_VALUE);
        //    //1. 一次读取一个字节
        //    //int temp ;
        //    //while ((temp = inputStream.read()) != -1){
        //    //    System.out.print((char) temp);
        //    //}
        //    //System.out.println();
        //    //2. 一次读取一组字节
        //    //inputStream.reset();
        //    byte[] bytes = new byte[4];
        //    int length ;
        //    while ((length = inputStream.read(bytes)) !=-1){
        //        System.out.print(new String(bytes));
        //    }
        //} catch (FileNotFoundException e) {
        //    e.printStackTrace();
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}

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
