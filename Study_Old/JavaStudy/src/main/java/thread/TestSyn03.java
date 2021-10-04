package thread;

/**
 * @Classname TestSyn03
 * 静态Synchronized方法
 * @Date 2020/02/08 20:12
 * @Created by lan-mao.top
 */

public class TestSyn03 {
    public static void main(String[] args) {
        Test02 test = new Test02();
        Test02 test2 = new Test02();
        new Thread(test,"1").start();
        new Thread(test2,"2").start();
        new Thread(test,"3").start();
        new Thread(test,"4").start();
        new Thread(test,"5").start();
    }
}
class Test02 implements Runnable{
    public synchronized static void synFaction1(){
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(100);
                System.out.println("同步——第一个对象静态同步方法");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized static void synFaction2(){
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(100);
                System.out.println("同步——第二个对象静态同步方法");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void synFaction3(){
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(100);
                System.out.println("非同步——静态非同步方法");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized  void synFaction4(){
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(100);
                System.out.println("同步——实例同步方法");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized  void synFaction5(){
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(100);
                System.out.println("非同步——实例非同步方法");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void run() {
        switch (Thread.currentThread().getName()){
            case "1":synFaction1(); break;
            case "2":synFaction2(); break;
            case "3":synFaction3(); break;
            case "4":synFaction4(); break;
            case "5":synFaction5(); break;
        }
    }
}
