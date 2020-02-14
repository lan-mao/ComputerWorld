package stream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @Classname TestIO12
 * 分割并合并文件
 *  - RandomAccessFile
 *  - SequenceInputStream
 * @Date 2020/02/06 11:05
 * @Created by lan-mao.top
 */

public class SplitFile {
    private File file;
    private int size;//1Kib 一块大小
    private int num; //多少块 向上取整
    private long length;
    private List<String> listPartFile;

    public SplitFile(String filePath, int size) {
        this.file = new File(filePath);
        this.size = size;
        length = file.length();
        num = (int) Math.ceil(length*1.0/size);
        listPartFile = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String name = "dest/" + i + "-" + file.getName();
            listPartFile.add(name);
        }
    }

    public SplitFile(String filePath) {
        this(filePath, 1024);
    }

    public void split (){
        long length = file.length(); //总共大小
        try (RandomAccessFile stream = new RandomAccessFile(file,"r");){
            byte[] temp = new byte[size];
            long point = 0;
            for (int i = 0; i < num; i++) {
                stream.seek(point);
                int readLength = stream.read(temp);
                try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(listPartFile.get(i)))) {
                    out.write(temp, 0, readLength);
                    out.flush();
                }
                point += readLength;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void merge (String filePath) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        Vector<InputStream> inputStreamList = new Vector<>();
        for (int i = 0; i < num; i++) {
            try {
                inputStreamList.add(new BufferedInputStream(new FileInputStream(listPartFile.get(i))));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        try (SequenceInputStream sequenceInputStream = new SequenceInputStream(inputStreamList.elements())) {
            Copy.copy(sequenceInputStream, fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SplitFile splitFile = new SplitFile("JavaStudy/src/main/java/day15/SplitFile.java", 512);
        splitFile.split();
        try {
            splitFile.merge("JavaStudy/src/main/java/day15/SplitFile2.java");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
