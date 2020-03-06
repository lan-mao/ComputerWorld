import cn.hutool.core.io.FileUtil;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;
import java.util.Collection;
import java.util.List;

/**
 * @Classname TestJAVE
 *  使用JAVE计算视频长度
 * @Date 2020/02/13 23:36
 * @Created by lan-mao.top
 */

public class TestJAVE {
    private static Object flag = new Object();
    private static volatile long time = 0;

    /**
     * 获得当前目录下的视频文件时长
     *
     * @param folder
     * @return
     */
    public static long getVideosTime(String folder) {
        List<File> files = FileUtil.loopFiles(new File(folder), 1, (file) -> {
            return fileFilter(file);
        });
        return getTimeInList(files);
    }

    /**
     * 递归遍历文件夹中的视频文件，返回所有视频文件的时长
     *
     * @param folder
     * @return
     */
    public static long loopGetVideosTime(String folder) {
        List<File> files = FileUtil.loopFiles(folder, (file) -> {
            return fileFilter(file);
        });
        int length = files.size();
        System.out.println(String.format("共找到%d个视频文件", length));
        int theadNum = Thread.activeCount();
        time = 0;
        int amount = 10;
        int each = (int) Math.ceil(length/10.0);
        for (int i = 0; i < length; ) {
            List<File> fileList;
            if (i + each >= length) {
                fileList = files.subList(i, length - 1);
            } else
                fileList = files.subList(i, i + each);
            i += each;
            System.out.println(fileList);
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                long partTime = getTimeInList(fileList);
                synchronized (flag) {
                    time += partTime;
                }
            }).start();
        }
        while (Thread.activeCount() > theadNum) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return time;
    }

    private static boolean fileFilter(File file) {
        String type = file.getName().substring(file.getName().indexOf('.') + 1);
        if ((!"mp4".equals(type)) && (!"avi".equals(type)))
            return false;
        else return true;
    }

    private static long getTimeInList(Collection<File> files) {
        Encoder encoder = new Encoder();
        long time = 0;
        for (File file : files) {
            try {
                MultimediaInfo m = encoder.getInfo(file);
                long length = m.getDuration();
                time += length;
            } catch (EncoderException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().getName() + "-----------" + file.getAbsolutePath());
            }
        }
        return time;
    }

    public static void main(String[] args) {
        String file = "D:\\Source\\Video\\百战程序员\\16_手写SORM框架(学有余力同学观看)";
        long start = System.currentTimeMillis();
        long time = loopGetVideosTime(file);
        long end = System.currentTimeMillis();
        System.out.println(String.format("运行了%f秒", (end - start) / 1000.0));
        long second = time / 1000;
        long minute = second / 60;
        long hour = minute / 60;
        second %= 60;
        minute %= 60;
        System.out.println(String.format("%d:%d:%d", hour, minute, second));
    }
}