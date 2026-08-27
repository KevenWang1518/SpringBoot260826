package com.wyjun.SpringBoot02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SnakeGame extends JFrame {
    public SnakeGame() {
        this.setTitle("贪吃蛇");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(new GamePanel());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SnakeGame::new);
    }
}

class GamePanel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
    static final int INITIAL_DELAY = 120; // 毫秒,数值越小蛇跑得越快

    final int[] x = new int[GAME_UNITS];
    final int[] y = new int[GAME_UNITS];

    int bodyParts;
    int applesEaten;
    int appleX;
    int appleY;
    char direction; // 'U' 'D' 'L' 'R'
    boolean running;
    static int highScore = 0; // 本次运行期间的最高分

    Timer timer;
    Random random;

    GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(new Color(25, 25, 25));
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame() {
        bodyParts = 6;
        applesEaten = 0;
        direction = 'R';
        for (int i = 0; i < bodyParts; i++) {
            x[i] = 100 - i * UNIT_SIZE;
            y[i] = 100;
        }
        newApple();
        running = true;
        if (timer != null) {
            timer.stop();
        }
        // 修复：每一局都重置速度回到初始值
        timer = new Timer(INITIAL_DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (running) {
            // 背景网格
            g.setColor(new Color(40, 40, 40));
            for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
                g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
                g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
            }

            // 食物
            g.setColor(Color.RED);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            // 蛇身
            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g.setColor(new Color(0, 220, 0));
                } else {
                    g.setColor(new Color(0, 160, 0));
                }
                g.fillRoundRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE, 8, 8);
            }

            // 分数
            g.setColor(Color.WHITE);
            g.setFont(new Font("SansSerif", Font.BOLD, 20));
            String scoreText = "分数: " + applesEaten;
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString(scoreText, (SCREEN_WIDTH - metrics.stringWidth(scoreText)) / 2, 25);
        } else {
            gameOver(g);
        }
    }

    public void newApple() {
        int newX, newY;
        boolean onSnake;
        do {
            onSnake = false;
            newX = random.nextInt(SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE;
            newY = random.nextInt(SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE;
            for (int i = 0; i < bodyParts; i++) {
                if (x[i] == newX && y[i] == newY) {
                    onSnake = true;
                    break;
                }
            }
        } while (onSnake); // 避免食物生成在蛇身上
        appleX = newX;
        appleY = newY;
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        if (direction == 'U') {
            y[0] -= UNIT_SIZE;
        } else if (direction == 'D') {
            y[0] += UNIT_SIZE;
        } else if (direction == 'L') {
            x[0] -= UNIT_SIZE;
        } else if (direction == 'R') {
            x[0] += UNIT_SIZE;
        }
    }

    public void checkApple() {
        if (x[0] == appleX && y[0] == appleY) {
            bodyParts++;
            applesEaten++;
            newApple();
            // 每吃5个食物稍微加速一次,但不会快得离谱
            if (applesEaten % 5 == 0 && timer.getDelay() > 50) {
                timer.setDelay(timer.getDelay() - 8);
            }
        }
    }

    public void checkCollisions() {
        // 撞到自己身体
        for (int i = bodyParts; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i]) {
                running = false;
                break;
            }
        }
        // 撞墙
        if (x[0] < 0 || x[0] >= SCREEN_WIDTH || y[0] < 0 || y[0] >= SCREEN_HEIGHT) {
            running = false;
        }
        if (!running) {
            timer.stop();
            if (applesEaten > highScore) {
                highScore = applesEaten;
            }
        }
    }

    public void gameOver(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("SansSerif", Font.BOLD, 40));
        String line1 = "游戏结束";
        FontMetrics m1 = getFontMetrics(g.getFont());
        g.drawString(line1, (SCREEN_WIDTH - m1.stringWidth(line1)) / 2, SCREEN_HEIGHT / 2 - 60);

        g.setFont(new Font("SansSerif", Font.BOLD, 24));
        FontMetrics m2 = getFontMetrics(g.getFont());
        String line2 = "本局分数: " + applesEaten + "   最高分: " + highScore;
        g.drawString(line2, (SCREEN_WIDTH - m2.stringWidth(line2)) / 2, SCREEN_HEIGHT / 2 - 10);

        g.setFont(new Font("SansSerif", Font.PLAIN, 18));
        FontMetrics m3 = getFontMetrics(g.getFont());
        String line3 = "按空格键重新开始";
        g.drawString(line3, (SCREEN_WIDTH - m3.stringWidth(line3)) / 2, SCREEN_HEIGHT / 2 + 30);
    }

    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
                if (direction != 'R') direction = 'L';
            } else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
                if (direction != 'L') direction = 'R';
            } else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
                if (direction != 'D') direction = 'U';
            } else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
                if (direction != 'U') direction = 'D';
            } else if (key == KeyEvent.VK_SPACE) {
                if (!running) startGame();
            }
        }
    }
}