package com.soft1841.io;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.*;


/**
 * 图片读取窗体
 */
public class ImgReaderFrame extends JFrame implements ActionListener {
    private JTextField inputField;
    private JButton confirmButton;
    private JPanel topPanel;
    private JLabel imgLable;
    private Icon icon;

    public ImgReaderFrame(){
        init();
        setTitle("图片阅读程序");
        setSize(1000,1000);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    public void init(){
        inputField = new JTextField(20);
        inputField.setPreferredSize(new Dimension(120,40));
        confirmButton = new JButton("确认");
        confirmButton.setPreferredSize(new Dimension(100,40));
        //给组件注册监听
        confirmButton.addActionListener(this);
        topPanel =new JPanel();
        //中间的多行文本域
        topPanel.add(inputField);
        topPanel.add(confirmButton);
        add(topPanel, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        new ImgReaderFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //获取输入框内容
        String filePath = inputField.getText().trim();
        File file=new File(filePath);
        try {
            InputStream inputStream = new FileInputStream(file);
            byte[] bytes =new byte[(int) file.length()];
            //读入内容到字节数组
            inputStream.read(bytes);
            imgLable=new JLabel();
            icon=new ImageIcon(bytes);
            imgLable.setIcon(icon);
            add(imgLable,BorderLayout.CENTER);
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(null,"IO操作异常");
        }
    }
}
