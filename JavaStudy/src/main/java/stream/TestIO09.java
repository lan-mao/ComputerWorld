package stream;

import java.io.*;

/**
 * @Classname TestIO09
 * 数据流
 * @Date 2020/02/05 22:58
 * @Created by lan-mao.top
 */

public class TestIO09 {
    public static void main(String[] args) {
        byte[] bytes = null;
        //写出
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(byteArrayOutputStream));){
            dataOutputStream.writeUTF("test_test");
            dataOutputStream.writeInt(123);
            dataOutputStream.writeChar('q');
            dataOutputStream.writeBoolean(true);
            dataOutputStream.flush();
            bytes = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(DataInputStream inputStream = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(bytes)))) {
            String str = inputStream.readUTF();
            int a = inputStream.readInt();
            char b = inputStream.readChar();
            boolean c = inputStream.readBoolean();
            System.out.println(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
