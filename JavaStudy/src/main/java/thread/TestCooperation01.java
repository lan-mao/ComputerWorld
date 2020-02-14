package thread;

/**
 * @Classname TestCooperation01
 * TODO 使用管控法解决生产消费者模式
 * @Date 2020/02/09 14:53
 * @Created by lan-mao.top
 */

public class TestCooperation01 {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Thread(new Producer(container)).start();
        new Thread(new Consumer(container)).start();
    }
}
//生产者
class Producer implements Runnable{
    SynContainer container ;

    public Producer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        //生产
        for (int i = 0; i < 100; i++) {
            container.push(new SteamedBun(i));
            System.out.println(String.format("生产第%d个馒头",i));
        }
    }
}
//消费者
class Consumer implements Runnable{
    SynContainer container ;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        //消费
        for (int i = 0; i < 100; i++) {
            SteamedBun bun = container.pop();
            System.out.println(String.format("消费第%d个馒头",bun.id));
        }
    }
}
//缓冲区
class SynContainer{
    SteamedBun[] buns = new SteamedBun[10];
    int count = 0;
    public synchronized void push(SteamedBun bun){
        if (count == buns.length){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buns[count++] = bun;
        notify();
    }
    public synchronized SteamedBun pop(){
        if (count == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
        return buns[--count];
    }

}
//馒头
class SteamedBun{
    int id;

    public SteamedBun(int id) {
        this.id = id;
    }
}