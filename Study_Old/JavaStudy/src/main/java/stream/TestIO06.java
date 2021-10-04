package stream;

import java.io.*;

/**
 * @Classname TestIO06
 *  内存与文件间传输
 *  - 将文件写入到内存
 *      - 从文件中读取数据
 *      - 将数据写入到内存
 *  - 把文件从内存中读出
 *      - 从内存中读取数据
 *      - 将数据写入到文件
 * @Date 2020/02/05 8:43
 * @Created by lan-mao.top
 */

public class TestIO06 {
    public static void main(String[] args) {
        String filepath = "ball.png";
        byte[] data = fileToByteArray(filepath);
        System.out.println(data.length);
        String dest = "ball2.png";
        byteArrayToFile(data, dest);
    }
    public static byte[] fileToByteArray(String filepath){
        byte[] data = null ;
        File file = new File(filepath);
        try (InputStream inputStream = new FileInputStream(file);
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()){
            byte[] temp = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(temp)) != -1){
                outputStream.write(temp, 0, length);
            }
            outputStream.flush();
            data = outputStream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    
    public static void byteArrayToFile (byte[] data, String filepath){
        File dest = new File(filepath);
        try(InputStream inputStream = new ByteArrayInputStream(data);
            OutputStream outputStream = new FileOutputStream(dest);){
            byte[] temp = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(temp)) != -1){
                outputStream.write(temp, 0, length);
            }
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
