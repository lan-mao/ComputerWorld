package basic;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class BallGame extends JFrame {
    URL ballUrl = BallGame.class.getClassLoader().getResource("images/ball.png");
    Image ball = Toolkit.getDefaultToolkit().getImage("ball.png");
    URL deskUrl = BallGame.class.getClassLoader().getResource("images/desk.jpg");
    Image desk = Toolkit.getDefaultToolkit().getImage(deskUrl);

    @Override
    public void paint(Graphics g) {
        System.out.println("窗口画了一次");
        ball.flush();
        g.drawImage(ball, 100, 100, null);
        System.out.println("加载图片：" );
        System.out.println(BallGame.class.getResource("/"));
        
    }

    /**
     * 窗口加载
     */
    void launchFrame(){
        //窗口大小
        setSize(300,300);
        //窗口在屏幕xy轴的位置
        setLocation(100,100);
        //
        setVisible(true);
        //
        //while(true){
        //    try {
        //        Thread.sleep(40);
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //}
    }
    public static void main(String[] args) {
        //BallGame game = new BallGame();
        //game.ball.flush();
        ////URL url = BallGame.class.getClassLoader().getResource("images/ball.png");
        //File file = new File(BallGame.class.getResource("/").getFile());
        //System.out.println(file.getAbsolutePath());
        //System.out.println(file.exists());
        //System.out.println(file.length());
        //System.out.println(file.exists()? file.getName() : false);
        //System.out.println("桌球游戏");
        //game.launchFrame();
    }
}
