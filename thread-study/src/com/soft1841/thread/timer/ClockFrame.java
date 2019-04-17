package com.soft1841.thread.timer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 时钟倒计时
 */
public class ClockFrame extends JFrame {
    private JLabel timeLabel;
    private TimerTask clockTask;
    private Timer clock;

    public ClockFrame(){
        init();
        setTitle("时钟");
        setSize(530,360);
        //设置位置
        setLocation(1350,10);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init(){
        JPanel jPanel = new JPanel(){
          protected void paintComponent(Graphics g){
              try {
                  Image ph = ImageIO.read(new File("D:\\ph.png"));
                  g.drawImage(ph,0,0,getWidth(),getHeight(),null);
              }catch (IOException e){
                  e.printStackTrace();
              }
          }
        };
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER,200,200));
        add(jPanel);

        timeLabel = new JLabel();
        Font font = new Font("微软雅黑",Font.BOLD,23);
        timeLabel.setFont(font);
        jPanel.add(timeLabel);
        clockTask = new TimerTask() {
            @Override
            public void run() {
                Date date = new Date();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String timeString = df.format(date);
                timeLabel.setText(timeString);
                if (timeString.equals("2019-04-16 09:19:10")){
                    //把null改成jPanel使弹框在闹钟面板里
                    JOptionPane.showMessageDialog(jPanel,"时间到");
                }
            }
        };
         clock = new Timer();
         clock.scheduleAtFixedRate(clockTask,0,1000);
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new ClockFrame();
    }
}
