package thread;

/**
 * @Classname TestSyn05
 * 同步方法和同步块同时使用
 * @Date 2020/02/08 22:27
 * @Created by lan-mao.top
 */

public class TestSyn05 {
    public static void main(String[] args) {
        Test04 test = new Test04();
        new Thread(test).start();
        test.testSyn1();
    }
}
class Test04 implements Runnable{
    public synchronized void testSyn1(){
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        synchronized (this){
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}