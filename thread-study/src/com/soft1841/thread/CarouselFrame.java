package com.soft1841.thread;

import javax.swing.*;

public class CarouselFrame extends JFrame {
    private JLabel bgLabel;
    public CarouselFrame(){
        init();
        setTitle("轮播窗体");
        //窗体最大化
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private void init(){
        bgLabel = new JLabel();
        add(bgLabel);
        CarouselThread ct = new CarouselThread();
        ct.setBgLabel(bgLabel);
        //与new Thread(ct).start();意思相同
        // Thread thread = new Thread(ct);
        //thread.start();
        new Thread(ct).start();
    }

    public static void main(String[] args) {
        new CarouselFrame();
    }
}
