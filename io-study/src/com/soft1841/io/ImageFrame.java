package com.soft1841.io;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 图片窗体程序
 * 3.26
 */
public class ImageFrame extends JFrame {
    //顶部面板
    private JPanel topPanel;
    private JButton[] buttons;
    //标签，用来容纳图片
    private JLabel imgLabel;
    //用来接收图片
    private Icon icon;
    //放入路径
    private JLabel path;
    //构造方法(和类名一致)
    public ImageFrame(){
        //调用init
        init();
        setTitle("图片窗体");
        setSize(1000,600);
        //窗体自动居中
        setLocationRelativeTo(null);
        //窗体可见
        setVisible(true);
        //关闭进程
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    //初始化组件（设置布局，放置组件）
    public void init() {
        //默认居中对齐
        topPanel = new JPanel();
        //创建5个按钮
        buttons = new JButton[5];
        for (int i =0;i<5;i++){
            buttons[i] = new JButton("按钮"+i+1);
            topPanel.add(buttons[i]);
        }
        add(topPanel, BorderLayout.NORTH);

        imgLabel = new JLabel("");
        //读入本地图片到内存的字节数组
        File srcFile = new File("D:/bj.jpg");
        FileInputStream in ;
        byte[] bytes = null;
        try {
            in = new FileInputStream(srcFile);
            bytes = new byte[(int) srcFile.length()];
            in.read(bytes);
        }catch (IOException e){
            System.out.println("IO异常");
        }
        icon = new ImageIcon(bytes);
        imgLabel.setIcon(icon);
        //加图片名字和位置
        add(imgLabel,BorderLayout.CENTER);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        JLabel time = new JLabel("当前时间"+sdf.format(date));
        add(time,BorderLayout.EAST);
        //图片路径
        String pathName = srcFile.getAbsolutePath();
        JLabel path = new JLabel("图片路径"+pathName);
        add(path,BorderLayout.WEST);
        //计算存储内存大小
        Long length = srcFile.length()/1024;
        JLabel label = new JLabel("大小："+String.valueOf(length)+"K");
        add(label,BorderLayout.SOUTH);
    }
    public static void main(String[] args) {
        new ImageFrame();
    }
}