package thread.piped;


import java.io.*;

/**
 * Create Date 2020/11/03 18:03:00 <br>
 * Created by lan-mao.top <br>
 * <br>
 *      * A -> Objects -> B
 *  * B -> Primitives -> A
 *  * C -> Object -> A
 *  * D -> Primitives -> A
 */
public class ThreadA extends ThreadBase{

    private final PipedOutputStream posA2B;
    private final PipedInputStream pisB2A;
    private final PipedInputStream pisC2A;
    private final PipedInputStream pisD2A;

    public ThreadA(String name, PipedOutputStream posA2B, PipedInputStream pisB2A, PipedInputStream pisC2A, PipedInputStream pisD2A) {
        super(name);
        this.posA2B = posA2B;
        this.pisB2A = pisB2A;
        this.pisC2A = pisC2A;
        this.pisD2A = pisD2A;
    }

    @Override
    public void run() {
        System.out.println( "Thread A starts execution..." );

        //A -> Objects -> B
        sendObjectData(new Message(10, 2), posA2B, "Thread B");

        //B -> Primitives -> A
        receivePrimitiveData(pisB2A, "Thread B");

        //C -> Object -> A
        receiveObjectData(pisC2A, "Thread C");

        //D -> Primitives -> A
        receivePrimitiveData(pisD2A, "Thread D");
    }
}

