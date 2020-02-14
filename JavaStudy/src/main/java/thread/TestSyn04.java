package thread;

/**
 * @Classname TestSyn04
 * 测试同步方法块
 * @Date 2020/02/08 21:49
 * @Created by lan-mao.top
 */

public class TestSyn04 {
    public static void main(String[] args) {
        Test03 test1 = new Test03();
        test1.name = "test";
        Test03 test2 = new Test03();
        test2.name = "test2";
        new Thread(test1, "线程1").start();
        for (int i = 0; i < 5; i++) {
            test1.testSyn1();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        new Thread(test2, "线程2").start();
        test2.run();
    }
}
class Test03 implements Runnable{
    String name;
    public void testSyn1(){
        System.out.println(Thread.currentThread().getName()+"\t实例" +name);
    }
    @Override
    public void run() {
        synchronized (this){
            for (int i = 0; i < 5; i++) {
                testSyn1();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}