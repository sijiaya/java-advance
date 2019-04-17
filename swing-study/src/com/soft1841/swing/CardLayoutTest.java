package com.soft1841.swing;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CardLayoutTest extends JFrame implements ActionListener {
    private JPanel cardPanel;
    private JButton preButton,nextButton;
    private JPanel buttonPanel;
    private CardLayout cardLayout;

    //头部定义、构造方法
    public CardLayoutTest(){
        init();
        setTitle("CardLayout卡片布局");
        setSize(900,600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    //init初始化方法
    private void init(){
        //创建卡片布局对象
        cardLayout = new CardLayout();
        //创建一个容器，设置成卡片布局
        cardPanel = new JPanel();
        cardPanel.setLayout(cardLayout);
        //循环调用三次，每次向容器中加入一个getPanel()方法得到的面板对象，并且编号为1，2，3
        for (int i = 0;i<3;i++){
            cardPanel.add(String.valueOf(i+1),getPanel());
        }
        //容器加入到窗体中间
        add(cardPanel);
        //底部按钮面板，放置两个按钮
        buttonPanel = new JPanel();
        preButton = new JButton("上一张");
        nextButton = new JButton("下一张");
        buttonPanel.setBackground(new Color(28,162,97));
        buttonPanel.add(preButton);
        buttonPanel.add(nextButton);
        //面板加入到窗体底部
        add(buttonPanel,BorderLayout.SOUTH);
        //给按钮设置监听
        preButton.addActionListener(this);
        nextButton.addActionListener(this);
    }

    //getPanel()方法、主方法
    private JPanel getPanel(){
        //内部方法，返回一个随机背景色的JPanel对象
        JPanel newPanel = new JPanel();
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        newPanel.setBackground(new Color(r,g,b));
        return newPanel;
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch (Exception e){
            e.printStackTrace();
        }
        new CardLayoutTest();
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //点击“上一张”按钮
        if (e.getSource() == preButton){
            //调用previous显示上一张
            cardLayout.previous(cardPanel);
        }else {
            //调用next显示下一张
            cardLayout.next(cardPanel);
        }
    }
}