package com.soft1841.thread;

import javax.swing.*;
import java.io.*;

public class CarouselThread implements Runnable{
    //准备图片路径数组
    private String[] imgs = {"D:/carousel/2.jpg","D:/carousel/3.jpg","D:/carousel/4.jpg","D:/carousel/5.jpg","D:/carousel/6.jpg","D:/carousel/7.jpg"};
    //定义一个图片标签
    private JLabel bgLabel;

    public void setBgLabel(JLabel bgLabel){
        this.bgLabel = bgLabel;
    }
    @Override
    public void run() {
        int i = 0;
        int len = imgs.length -1;
        while (true){
            //通过路径构建file对象
            try {
                File file = new File(imgs[i]);
                InputStream inputStream = new FileInputStream(file);
                byte[] bytes = new byte[(int) file.length()];
                inputStream.read(bytes);
                Icon icon = new ImageIcon(bytes);
                bgLabel.setIcon(icon);
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
            }
            i++;
            if (i == len){
                i = 0;
            }
        }catch (IOException e){
                System.out.println("IO异常");
            }
        }
}
}
