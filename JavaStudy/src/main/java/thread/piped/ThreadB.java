package thread.piped;

/*
  Create Date 2020/11/03 18:03:00 <br>
  Created by lan-mao.top <br>
  <br>
 */

import java.io.*;

/**
 * TA - Object -> TB
 * TC - Object -> TB
 * TB - Primitives -> TA
 * TB - Object -> TC
 */
public class ThreadB extends ThreadBase{

    private final PipedInputStream pisA2B;
    private final PipedInputStream pisC2B;
    private final PipedOutputStream posB2A;
    private final PipedOutputStream posB2C;

    public ThreadB(String name, PipedInputStream pisA2B, PipedInputStream pisC2B, PipedOutputStream posB2A, PipedOutputStream posB2C) {
        super(name);
        this.pisA2B = pisA2B;
        this.pisC2B = pisC2B;
        this.posB2A = posB2A;
        this.posB2C = posB2C;
    }

    @Override
    public void run() {
        System.out.println( getName() + " starts execution..." );
        // TB - Primitives -> TA
        sendPrimitiveData(100, posB2A, "Thread A");
        // TB - Object -> TC
        sendObjectData(new Message(100, 1), posB2C, "Thread C");
        // TA - Object -> TB
        receiveObjectData(pisA2B, "Thread A");
        // TC - Object -> TB
        receiveObjectData(pisC2B, "Thread C");

    }
}
