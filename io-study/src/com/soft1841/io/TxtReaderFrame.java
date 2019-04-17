package com.soft1841.io;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * txt文件阅读器窗体
 */
public class TxtReaderFrame extends JFrame implements ActionListener {
    //组件
    private JTextField inputField;
    private JButton confirmButton;
    private JPanel topPanel;
    private JTextArea contentArea;

    public TxtReaderFrame(){
        init();
        setTitle("文本阅读窗体");
        setSize(new Dimension(640,480));
        //居中
        setLocationRelativeTo(null);
        setVisible(true);
        //将窗体关闭
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init(){
        Font font = new Font("微软雅黑",Font.PLAIN,25);
        //顶部面板
        inputField = new JTextField(20);
        //设置字体
        inputField.setFont(font);
        //设置合适大小
        inputField.setPreferredSize(new Dimension(120,40));
        confirmButton = new JButton("确认");
        confirmButton.setPreferredSize(new Dimension(100,40));
        topPanel = new JPanel();

        topPanel.add(inputField);
        topPanel.add(confirmButton);

        //监听在本窗体发生作用（给按钮注册监听）
        confirmButton.addActionListener(this);

        add(topPanel, BorderLayout.NORTH);
        //中间的多行文本域
        contentArea = new JTextArea();
        add(contentArea,BorderLayout.CENTER);
        contentArea.setFont(font);
    }

    public static void main(String[] args) {
        new TxtReaderFrame();
    }

    /**
     * Invoked when an action occurs.
     * 监听设置
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //获取输入框内容
        String filePath = inputField.getText().trim();
        //创建文件
        File file = new File(filePath);
        //使用三种方法将file中的内容读入
        try {
            InputStream inputStream = new FileInputStream(file);
            //构建文件数组
            byte[] bytes = new byte[(int) file.length()];
            //读入内容到字节数组
            inputStream.read(bytes);
            //使用bytes构建一个新的输出字符串
            String resultStr = new String(bytes);
            contentArea.append(resultStr);
            //回车换行
            contentArea.append("\n\r");
        } catch (IOException e1) {
            //弹出对话框
            JOptionPane.showMessageDialog(null,"IO异常");
        }
    }
}
