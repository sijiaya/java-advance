package com.soft1841.swing;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;


/**
 * 文件选择器组件JFileChooser
 * 2019.4.2
 */
public class JFileChooserTest extends JFrame implements ActionListener {
    //定义组件
    private JButton chooseBtn;
    private  JLabel pathLabel;
    private JFileChooser fileChooser;
    public  JFileChooserTest(){
        init();
        setTitle("JFileChooserTest");
        setSize(800,600);
        //窗体居中
        setLocationRelativeTo(null);
        //可见
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    private void init(){
        chooseBtn = new JButton("选择文件");
        pathLabel = new JLabel("暂无选择");
        add(chooseBtn, BorderLayout.NORTH);
        //给按钮加事件监听,监听在本窗体发生作用
        chooseBtn.addActionListener(this);
        Font font = new Font("微软雅黑",Font.BOLD,23);
        pathLabel.setFont(font);
        add(pathLabel);
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch (Exception e){
            e.printStackTrace();
        }
        new JFileChooserTest();
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //创建选择器
        fileChooser = new JFileChooser();
//        //相对路径，根目录下内容
//        fileChooser.setCurrentDirectory(new File("."));
        //设置文件选择器的默认路径(设置当前目录)
        fileChooser.setCurrentDirectory(new File("E:\\"));
        //打开对话框
        int result = fileChooser.showOpenDialog(null);
        //用户点击“确认”按钮
        if (result == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            try {
                InputStream inputStream = new FileInputStream(file);
                Scanner scanner = new Scanner(inputStream);
                pathLabel.setText(scanner.nextLine());
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
//            //只显示file的绝对路径显示在窗体中间
//            pathLabel.setText(file.getAbsolutePath());
        }
    }
}
