package com.soft1841.thread.test;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ShadePanel extends JPanel implements Runnable{
    public ShadePanel(){
        Timer timer = new Timer();
               timer.schedule(timerTask,0,1000);
    }
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            repaint();
            System.out.println("测试");
        }
    };

    //    TimerTask timerTask = new TimerTask() {
//        @Override
//        public void run() {
//            Timer timer = new Timer();
//            timer.schedule(timerTask,0,1000);
//            repaint();
//            System.out.println("测试");
//        }
//    };
    @Override
    protected void paintComponent(Graphics g2) {
        Graphics2D g = (Graphics2D) g2;
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        Color[] color = {Color.cyan,Color.GREEN,Color.blue,Color.GRAY};
        Random r = new Random();
        int i = r.nextInt(2);
        int j = r.nextInt(2);
        //创建填充模式对象
        GradientPaint paint = new GradientPaint(i, j, color[i], 0, height,color[j]);
        g.setPaint(paint);
        g.fillRect(i, j, width, height);
    }

    @Override
    public void run() {
        while (true) {
            repaint();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
