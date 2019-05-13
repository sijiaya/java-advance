package com.soft1841.gui;

import javax.swing.*;

public class YouKuFrame {
    private JPanel mainPanel;
    private JScrollPane scroll;
    private JPanel leftPanel;
    private JButton 剧集Button;
    private JButton 精选Button;
    private JButton 电影Button;
    private JButton 综艺Button;
    private JButton 少儿Button;
    private JButton 音乐Button;
    private JPanel topPanel;
    private JPanel headPanel;
    private JLabel iconLabel;
    private JButton 主页Button;
    private JButton 播放Button;
    private JButton 来疯Button;
    private JPanel centerPanel;
    private JButton 动漫Button;
    private JButton 游戏Button;
    private JButton 搞笑Button;
    private JButton 资讯Button;
    private JLabel photo1Label;
    private JPanel filmPanel;
    private JLabel photo2Label;
    private JLabel photo3Label;
    private JLabel photo4Label;
    private JLabel photo5Label;
    private JLabel photo6Label;
    private JLabel likeLabel;

    public static void main(String[] args) throws Exception{
        //根据系统设置swing外观
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(lookAndFeel);
        JFrame frame = new JFrame("YouKuFrame");
        frame.setContentPane(new YouKuFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //全屏
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
