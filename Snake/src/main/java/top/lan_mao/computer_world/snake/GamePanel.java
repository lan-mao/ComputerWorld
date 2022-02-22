package top.lan_mao.computer_world.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * Create Date 2022/01/14 11:16:54 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 * <br>
 */
public class GamePanel extends JPanel implements KeyListener, ActionListener {

    private int width;
    private int height;
    private int leftBoundary;
    private int rightBoundary;
    private int upBoundary;
    private int downBoundary;

    private int length;
    private int[][] snakeXY = new int[500][2];
    private Direction direction;

    private boolean isStarted;
    private boolean isFail;

    private int foodx, foody;

    /**
     * 定义定时器，时间间隔100毫秒，执行操作是this.actionPerformed()
     */
    Timer timer = new Timer(200, this);

    public GamePanel() {
        init();
        // 获取键盘焦点，并添加键盘监听器
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();
    }

    private void init() {
        width = 850;
        height = 600;
        leftBoundary = 25;
        rightBoundary = leftBoundary + width;
        upBoundary = 75;
        downBoundary = upBoundary + height;
        length = 3;
        snakeXY[0] = new int[]{100, 100};
        snakeXY[1] = new int[]{75, 100};
        snakeXY[2] = new int[]{50, 100};
        direction = Direction.RIGHT;


        foodx = leftBoundary + Data.headWidth * new Random().nextInt(width / Data.headWidth);
        foody = upBoundary + Data.headHeight * new Random().nextInt(height / Data.headHeight);

        isFail = false;
        isStarted = false;
    }

    /**
     * 绘制界面
     * Graphics ：画笔
     */
    @Override
    protected void paintComponent(Graphics g) {
        // 清屏
        super.paintComponent(g);
        this.setBackground(Color.white);

        // 绘制头部广告栏
        Data.header.paintIcon(this, g, 25, 11);

        // 绘制游戏区域
        // 填充矩形
        g.fillRect(leftBoundary, upBoundary, width, height);

        // 画一个小蛇
        switch (direction) {
            case RIGHT: {
                Data.right.paintIcon(this, g, snakeXY[0][0], snakeXY[0][1]);
                break;
            }
            case LEFT: {
                Data.left.paintIcon(this, g, snakeXY[0][0], snakeXY[0][1]);
                break;
            }
            case UP: {
                Data.up.paintIcon(this, g, snakeXY[0][0], snakeXY[0][1]);
                break;
            }
            case DOWN: {
                Data.down.paintIcon(this, g, snakeXY[0][0], snakeXY[0][1]);
                break;
            }
            default:
                break;
        }

        for (int i = 1; i < length; i++) {
            Data.body.paintIcon(this, g, snakeXY[i][0], snakeXY[i][1]);
        }

        // 游戏提示
        if (!isStarted && !isFail) {
            g.setColor(Color.red);
            g.setFont(new Font("汉仪瑞兽 W", Font.BOLD, 40));
            g.drawString("按下空格开始游戏", 300, 300);
        }
        // 失败提示
        if (isFail && !isStarted) {
            g.setColor(Color.red);
            g.setFont(new Font("汉仪乐喵体 W", Font.BOLD, 40));
            g.drawString("游戏失败，按空格重新开始。", 200, 300);
            isFail = false;
        }

        Data.food.paintIcon(this, g, foodx, foody);
    }


    /**
     * 键盘按下未释放
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_SPACE: {
                isStarted = !isStarted;
                break;
            }
            case KeyEvent.VK_LEFT:
                direction = Direction.LEFT;
                break;
            case KeyEvent.VK_RIGHT:
                direction = Direction.RIGHT;
                break;
            case KeyEvent.VK_UP:
                direction = Direction.UP;
                break;
            case KeyEvent.VK_DOWN:
                direction = Direction.DOWN;
                break;
            default:
                break;
        }
        // 重新绘制界面
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 如果游戏开始了，就让小蛇移动
        if (isStarted) {
            // 移动身体，全体向前移动一格即可
            for (int i = length - 1; i > 0; i--) {
                snakeXY[i][0] = snakeXY[i - 1][0];
                snakeXY[i][1] = snakeXY[i - 1][1];
            }
            // 根据方向更改头部的移动
            switch (direction) {
                default:
                    break;
                case RIGHT: {
                    snakeXY[0][0] += Data.headWidth;
                    if (snakeXY[0][0] > rightBoundary - Data.headWidth) {
                        snakeXY[0][0] = leftBoundary;
                    }
                    break;
                }
                case LEFT: {
                    snakeXY[0][0] -= Data.headWidth;
                    if (snakeXY[0][0] < leftBoundary) {
                        snakeXY[0][0] = rightBoundary - Data.headWidth;
                    }
                    break;
                }
                case UP: {
                    snakeXY[0][1] -= Data.headHeight;
                    if (snakeXY[0][1] < upBoundary) {
                        snakeXY[0][1] = downBoundary - Data.headHeight;
                    }
                    break;
                }
                case DOWN: {
                    snakeXY[0][1] += Data.headHeight;
                    if (snakeXY[0][1] > downBoundary - Data.headHeight) {
                        snakeXY[0][1] = upBoundary;
                    }
                    break;
                }
            }

            // 判断食物，以及长身体

            if (snakeXY[0][0] == foodx && snakeXY[0][1] == foody) {
                snakeXY[length][0] = snakeXY[length - 1][0];
                snakeXY[length][1] = snakeXY[length - 1][1];
                length++;
                foodx = leftBoundary + Data.headWidth * new Random().nextInt(width / Data.headWidth);
                foody = upBoundary + Data.headHeight * new Random().nextInt(height / Data.headHeight);
                timer.setDelay(200 - length / 2);
            }

            // 如果头与身体重合则判断失败
            for (int i = 1; i < length; i++) {
                if (snakeXY[0][0] == snakeXY[i][0] && snakeXY[0][1] == snakeXY[i][1]) {
                    isFail = true;
                    isStarted = false;
                    init();
                    break;
                }
            }

            repaint();
        }
    }

    /**
     * 键盘按下并释放
     */
    @Override
    public void keyReleased(KeyEvent e) {
    }

    /**
     * 键盘按下弹起
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }
}

enum Direction {
    /**
     * 上
     */
    UP,
    /**
     * 下
     */
    DOWN,
    /**
     * 右
     */
    RIGHT,
    /**
     * 左
     */
    LEFT
}