package com.soft1841.graphics;

import javax.swing.*;
import java.awt.*;

public class DrawImageTest extends JFrame{
    public DrawImageTest(){
        //设置窗体大小
        this.setSize(500,380);
        //设置窗体关闭模式
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //设置窗体面板为绘制面板对象
        add(new CanvasTest());
        this.setTitle("绘制图像");
    }

    public static void main(String[] args) {
        //使窗体可见
        new DrawImageTest().setVisible(true);
    }

    //创建画布
    class CanvasTest extends Canvas {
        public void paint(Graphics g){
            super.paint(g);
            //创建绘图对象
            Graphics2D g2 = (Graphics2D) g;
            //获取图片资源
//            Image img = new ImageIcon("/img/1.jpg").getImage();
            Image img = new ImageIcon(this.getClass().getResource("/img/1.jpg")).getImage();
            //显示图像
            g2.drawImage(img,0,0,this);
        }
    }
}
