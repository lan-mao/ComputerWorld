package thread;

/**
 * @Classname TestHappyBefore
 *  代码重排
 * @Date 2020/02/09 17:37
 * @Created by lan-mao.top
 */

public class TestHappyBefore {
    private static int num = 0;
    private static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            num = 0;
            flag = false;
            Thread t1 = new Thread(()->{
                //System.out.println("Thread1---------->"+num);
                num = 0;
                flag = true;
                //System.out.println("Thread1------------end");
            });
            Thread t2 = new Thread(()->{
                //System.out.println("Thread2---------->"+num);
                if (flag){
                    num =1;
                }
                if (num == 0){
                    System.out.println("---------->"+num);
                }
                //System.out.println("Thread2------------end");
            });
            t1.start();
            t1.join();
            t2.start();
            t2.join();
        }
    }
}
