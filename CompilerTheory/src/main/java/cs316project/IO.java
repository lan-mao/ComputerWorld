package cs316project;

import java.io.*;


public class IO {
    private static BufferedReader reader = null;
    private static BufferedWriter writer = null;

    //用于存储读取到的所有文字
    private static StringBuilder text = new StringBuilder();
    //记录当前读取到的位置
    private static int flag = 0;

    public static void setIO(String[] values) {
        if (values.length != 0) {
            String inPath = values[0];
            String outPath = values[1];
            try {
                reader = new BufferedReader(new FileReader(inPath));
                writer = new BufferedWriter(new FileWriter(outPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            reader = new BufferedReader(new InputStreamReader(System.in));
            writer = new BufferedWriter(new OutputStreamWriter(System.out));
        }
    }


    /**
     * 获取下一个字符
     *
     * @return 返回下一个字符，如果到达结尾返回-1
     */
    public static int getNextChar() {
        try {
            //当flag处于text最后一位时，flag为text.length-1，此时自增1，flag==text.length说明上一次读取处于结尾
            //如果标志位为
            if (flag == text.length()){
                char[] temp = new char[10];
                int length = reader.read(temp);
                if (length == -1){
                    return -1;
                }
                text.append(new String(temp, 0, length));
            }
            return text.charAt(flag++);
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 将指针flag位置前移一位
     */
    public static void forward() {
        if (flag >= 0) {
            flag--;
        }
    }

    public static boolean hasNext(){
        try {
            if (flag < text.length()){
                return true;
            }else {
                char[] temp = new char[10];
                int length = reader.read(temp);
                if (length == -1){
                    return false;
                }
                text.append(new String(temp, 0, length));
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 向输出流中写入字符串
     *
     * @param value 需要写入的字符串
     */
    public static void print(String value) {
        try {
            writer.write(value);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向输出流中写入字符串并换行
     *
     * @param value 需要写入的字符串
     */
    public static void println(String value) {
        print(value + '\n');
    }

    public static void close() {
        try {
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}