package thread.piped;

import java.io.PipedOutputStream;

/**
 * TD - Primitives -> TA
 */
public class ThreadD extends ThreadBase{
    private final PipedOutputStream posD2A;

    public ThreadD(String name, PipedOutputStream posD2A) {
        super(name);
        this.posD2A = posD2A;
    }

    @Override
    public void run() {
        System.out.println( getName() + " starts execution..." );
        //TD - Primitives -> TA
        sendPrimitiveData(200, posD2A, "Thread A");
    }
}
