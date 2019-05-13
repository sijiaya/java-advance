package com.soft1841.gui;

import javax.swing.*;

public class CouldMusicFrame {
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JButton 搜索;
    private JButton 发现音乐;
    private JButton MV;
    private JButton 朋友;
    private JPanel centerPanel;
    private JLabel bannerLabel;
    private JLabel bottomLabel;
    private JPanel musicPanel;
    private JLabel img1Label;
    private JLabel img2Label;
    private JLabel img3Label;
    private JLabel img4Label;
    private JLabel img5Label;

    public static void main(String[] args) throws Exception{
        //根据系统设置swing外观
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(lookAndFeel);
        JFrame frame = new JFrame("CouldMusicFrame");
        frame.setContentPane(new CouldMusicFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
        //全屏
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
