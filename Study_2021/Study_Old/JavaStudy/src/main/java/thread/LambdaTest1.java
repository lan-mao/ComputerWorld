package thread;

/**
 * @Classname LambdaTest1
 * 通过实现Runnable接口，使用Lambda表达式
 * @Date 2020/02/07 20:05
 * @Created by lan-mao.top
 */

public class LambdaTest1{
    public static void main(String[] args){
        class RunnableImpl3 implements Runnable{
            @Override
            public void run() {
                System.out.println("局部内部类");
            }
        }

        new Thread(new RunnableImpl1()).start();
        new Thread(new RunnableImpl2()).start();
        new Thread(new RunnableImpl3()).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类");
            }
        }).start();

        new Thread(()->{
            System.out.println("Lambda表达式");
        }).start();
    }
    static class RunnableImpl2 implements Runnable{
        @Override
        public void run() {
            System.out.println("静态内部类");
        }
    }
}
class RunnableImpl1 implements  Runnable {
    @Override
    public void run() {
        System.out.println("外部类");
    }
}