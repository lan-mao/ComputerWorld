package thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Classname TestTimer
 * TODO 使用Timer创建定时器
 * @Date 2020/02/09 16:20
 * @Created by lan-mao.top
 */

public class TestTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new Task(), 1000);
    }
}
//TimerTask可以由Timer执行的任务
class Task extends TimerTask{
    //是否在进行番茄
    //T番茄开始
    //F休息开始
    static boolean flag = false;
    @Override
    public void run() {
        if (!flag){
            System.out.println("番茄开始");
            flag = true;
            Timer timer = new Timer();
            timer.schedule(new Task(),500);
        }else {
            System.out.println("休息开始");
            flag = false;
            Timer timer = new Timer();
            timer.schedule(new Task(),200);
        }
    }
}