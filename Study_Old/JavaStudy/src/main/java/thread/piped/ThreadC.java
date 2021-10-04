package thread.piped;

/**
 * Create Date 2020/11/03 18:03:00 <br>
 * Created by lan-mao.top <br>
 * <br>
 */

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * TB - Object -> TC
 * TC - Object -> TA
 * TC - Object -> TB
 */
public class ThreadC extends ThreadBase{
    private final PipedInputStream pisB2C;
    private final PipedOutputStream posC2A;
    private final PipedOutputStream posC2B;

    public ThreadC(String name, PipedInputStream pisB2C, PipedOutputStream posC2A, PipedOutputStream posC2B) {
        super(name);
        this.pisB2C = pisB2C;
        this.posC2A = posC2A;
        this.posC2B = posC2B;
    }

    @Override
    public void run() {
        System.out.println( getName() + " starts execution..." );
        //TC - Object -> TA
        sendObjectData(new Message(300, 20), posC2A, "Thread A");
        //TC - Object -> TB
        sendObjectData(new Message(300, 30), posC2B, "Thread B");
        //TB - Object -> TC
        receiveObjectData(pisB2C, "Thread B");
    }
}
