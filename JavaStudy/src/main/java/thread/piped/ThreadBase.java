package thread.piped;

import java.io.*;

/**
 * Create Date 2020/11/03 21:42:33 <br>
 * Created by lan-mao.top <br>
 * <br>
 */

public class ThreadBase extends Thread{

    public ThreadBase(String name) {
        super(name);
    }

    protected void sendObjectData (Message message, PipedOutputStream pos, String threadName){
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(pos))){
            oos.writeObject(message);
            oos.flush();
            System.out.printf("%s - send object data to %s : %s%n", getName(), threadName, message.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void receiveObjectData (PipedInputStream pis, String threadName){
        Message message = null;
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(pis))){
            Object o = ois.readObject();
            if (o instanceof Message) {
                 message = (Message) o;
                System.out.printf("%s - receives object data from %s : %s%n", getName(), threadName, message.toString());
            } else {
                System.out.printf("ERROR: %s - can't receives primitive data from %s%n", getName(), threadName);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void sendPrimitiveData (int data, PipedOutputStream pos, String threadName) {
        try {
            pos.write(data);
            System.out.printf("%s - send primitive data to %s : %s%n", getName(), threadName, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void receivePrimitiveData (PipedInputStream pis, String threadName) {
        try {
            int data = pis.read();
            System.out.printf("%s - receives primitive data from %s : %s%n", getName(), threadName, data);
        } catch (IOException e) {
            synchronized (this) {
                System.out.println(getName());
                e.printStackTrace();
            }
        }
    }

}
