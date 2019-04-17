package com.soft1841.thread.timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LoginFrame extends JFrame implements ActionListener {
    private JLabel accountLabel, passwordLabel;
    private JTextField accountField;
    private JPasswordField passwordField;
    private JButton confirmButton, cancelButton;
    private int width;
    private int height;
    public LoginFrame(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.width;
        height = screenSize.height;
        init();
        setTitle("登录界面");
        setSize(width, height);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void init(){
        setLayout(null);
        ShadePanel shadePanel = new ShadePanel();
        shadePanel.setLayout(null);
        shadePanel.setBounds(0, 0, width, height);
        Font font = new Font("楷体", Font.PLAIN, 30);
        accountLabel = new JLabel("账号");
        accountLabel.setFont(font);
        accountLabel.setForeground(new Color(242, 242, 242));
        accountField = new JTextField();
        accountField.setFont(font);
        passwordLabel = new JLabel("密码");
        passwordLabel.setFont(font);
        passwordLabel.setForeground(new Color(242, 242, 242));
        passwordField = new JPasswordField();
        passwordField.setFont(font);
        confirmButton = new JButton("确认");
        confirmButton.setFont(font);
        cancelButton = new JButton("取消");
        cancelButton.setFont(font);
        accountLabel.setBounds(40, 150, 100, 35);
        accountField.setBounds(200, 150, 260, 35);
        passwordLabel.setBounds(40, 220, 100, 35);
        passwordField.setBounds(200, 220, 260, 35);
        confirmButton.setBounds(60,300,100,35);
        cancelButton.setBounds(220,300,100,35);

        add(shadePanel);
        ShadePanel shadePanel1 = new ShadePanel();

    }

    public static void main(String[] args) {
        new LoginFrame();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
