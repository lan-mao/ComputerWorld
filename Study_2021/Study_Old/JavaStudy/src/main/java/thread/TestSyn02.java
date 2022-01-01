package thread;

/**
 * @Classname TestSyn02
 * 测试同步方法
 * @Date 2020/02/08 18:21
 * @Created by lan-mao.top
 */

public class TestSyn02 {
    public static void main(String[] args) {
        Test01 test = new Test01();
        new Thread(test, "1").start();
        new Thread(test, "2").start();
        new Thread(test, "3").start();
    }
}
class Test01 implements Runnable{
    static int num = 0;
    public synchronized void synFaction1(){
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
                System.out.println("1" + "----->" +Thread.currentThread().getName() +"----->" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void synFaction2(){
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
                System.out.println("2" + "----->" +Thread.currentThread().getName() +"----->" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void synFaction3(){
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
                System.out.println("3" + "----->" +Thread.currentThread().getName() +"----->" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        switch (num){
            case 0:{
                num++;
                synFaction1();
                break;
            }
            case 1:{
                num++;
                synFaction2();
                break;
            }
            case 2:{
                synFaction3();
            }
        }
    }
}