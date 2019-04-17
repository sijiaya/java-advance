package com.soft1841.swing;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * 使用卡片布局实现多图浏览功能
 */
public class ImageViewerFrame extends JFrame implements ActionListener {
    private JButton chooseBtn,preBtn,nextBtn,firstBtn,lastBtn;
    private JFileChooser fileChooser;
    private JPanel centerPanel,bottomPanel;
    private CardLayout cardLayout;

    public ImageViewerFrame(){
        init();
        setTitle("多图浏览");
        setSize(800,640);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init(){
        //处理按钮,底部放置三个按钮并设置监听
        bottomPanel = new JPanel();
        chooseBtn = new JButton("选择图片");
        preBtn = new JButton("上一张");
        nextBtn = new JButton("下一张");
        firstBtn = new JButton("第一张");
        lastBtn = new JButton("最后一张");
        //给按钮加事件监听,监听在本窗体发生作用
        bottomPanel.add(chooseBtn);
        bottomPanel.add(firstBtn);
        bottomPanel.add(preBtn);
        bottomPanel.add(nextBtn);
        bottomPanel.add(lastBtn);
        //给按钮添加监听事件
        chooseBtn.addActionListener(this);
        firstBtn.addActionListener(this);
        preBtn.addActionListener(this);
        nextBtn.addActionListener(this);
        lastBtn.addActionListener(this);
        add(bottomPanel,BorderLayout.SOUTH);
        centerPanel = new JPanel();
        cardLayout = new CardLayout();
        //设置布局为卡片布局
        centerPanel.setLayout(cardLayout);
        centerPanel.setBackground(new Color(60,63,65));
        add(centerPanel);
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch (Exception e){
            e.printStackTrace();
        }
        new ImageViewerFrame();
    }
    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //获得事件源
        if (e.getSource() == chooseBtn){
            //创建选择器
            fileChooser = new JFileChooser();
            //设置文件选择器的默认路径(设置当前目录)
            fileChooser.setCurrentDirectory(new File("E:\\image"));
            //设置文件多选模式
            fileChooser.setMultiSelectionEnabled(true);
            //打开对话框
            int result = fileChooser.showOpenDialog(null);
            //用户选择了文件
            if (result == JFileChooser.APPROVE_OPTION){
               //获取选中的所有文件，放到一个文件类型数组中
                File[] files = fileChooser.getSelectedFiles();
                //遍历文件数组
                for (File f:files) {
                    //输出图片的路径
                    System.out.println(f.getAbsolutePath());
                    //对每个f文件，创建字节输入流读入字节数组，创建Icon并设置给JLabel
                    try {
                        byte[] bytes = new byte[(int) f.length()];
                        InputStream inputStream = new FileInputStream(f);
                        inputStream.read(bytes);
                        Icon icon = new ImageIcon(bytes);
                        JLabel imgLabel = new JLabel();
                        imgLabel.setIcon(icon);
                        centerPanel.add(imgLabel);
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(null,"IO异常");
                }
            }
        }
    }
        //点击“上一张”按钮
        if (e.getSource() == preBtn){
            //调用previous显示上一张
            cardLayout.previous(centerPanel);
        }
        if (e.getSource() == nextBtn){
            cardLayout.next(centerPanel);
        }
        if (e.getSource() == firstBtn){
            cardLayout.first(centerPanel);
        }
        if (e.getSource() == lastBtn){
            cardLayout.last(centerPanel);
        }
    }
}
