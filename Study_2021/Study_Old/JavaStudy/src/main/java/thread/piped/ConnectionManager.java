package thread.pisd;

import thread.piped.ThreadA;
import thread.piped.ThreadB;
import thread.piped.ThreadC;
import thread.piped.ThreadD;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Create Date 2020/11/03 16:41:22 <br>
 * Created by lan-mao.top <br>
 * 管道管理 <br>
 */

public class ConnectionManager {
    //TA - Object -> TB
    static private PipedInputStream pisA2B = new PipedInputStream();
    static private PipedOutputStream posA2B = new PipedOutputStream();
    static private ObjectInputStream oisA2B;

    //TB - Primitives -> TA
    static private PipedInputStream pisB2A = new PipedInputStream();
    static private PipedOutputStream posB2A = new PipedOutputStream();

    //TB - Object -> TC
    static private PipedInputStream pisB2C = new PipedInputStream();
    static private PipedOutputStream posB2C = new PipedOutputStream();

    //TC - Object -> TA
    static private PipedInputStream pisC2A = new PipedInputStream();
    static private PipedOutputStream posC2A = new PipedOutputStream();

    //TC - Object -> TB
    static private PipedInputStream pisC2B = new PipedInputStream();
    static private PipedOutputStream posC2B = new PipedOutputStream();

    //TD - Primitives -> TA
    static private PipedInputStream pisD2A = new PipedInputStream();
    static private PipedOutputStream posD2A = new PipedOutputStream();


    public static void main(String[] args) {
        try {
            System.out.println("System start");
            pisA2B.connect(posA2B);
            pisB2A.connect(posB2A);
            pisB2C.connect(posB2C);
            pisC2A.connect(posC2A);
            pisC2B.connect(posC2B);
            pisD2A.connect(posD2A);

            ThreadA threadA = new ThreadA("Thread A", posA2B, pisB2A, pisC2A, pisD2A);
            ThreadB threadB = new ThreadB("Thread B", pisA2B, pisC2B, posB2A, posB2C);
            ThreadC threadC = new ThreadC("Thread C", pisB2C, posC2A, posC2B);
            ThreadD threadD = new ThreadD("Thread D", posD2A);

            threadA.start();
            threadB.start();
            threadC.start();
            threadD.start();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
