package thread;

/**
 * @Classname TestCooperation02
 *  信号灯法实现
 * @Date 2020/02/09 15:56
 * @Created by lan-mao.top
 */

public class TestCooperation02 {
    public static void main(String[] args) {
        Tv tv = new Tv();
        new Thread(new Player(tv)).start();
        new Thread(new Watcher(tv)).start();

    }
}

//生产者 演员
class Player implements Runnable{
    Tv tv ;

    public Player(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.play("表演"+ i);
        }
    }
}
//消费者 观众
class Watcher implements Runnable{
    Tv tv ;

    public Watcher(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}
//共享资源 电视
class Tv{
    String voice;
    //T 演员表演，观众等待
    //F 观众观看，演员等待
    boolean flag = true;

    public synchronized void play(String voice) {
        if (!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("表演了："+ voice);
        this.voice = voice;
        flag = false;
        notify();
    }
    public synchronized void watch (){
        if (flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("听到："+voice);
        flag = true;
        notify();
    }
}