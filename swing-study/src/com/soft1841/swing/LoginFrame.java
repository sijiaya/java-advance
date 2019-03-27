package com.soft1841.swing;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    //组件定义
    private JLabel accountLabel,passwordLabel,roleLabel;
    private JTextField accountField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;
    private JButton confirmButton,cancelButton;
    private JLabel bgLabel;
    //构造方法
    public LoginFrame(){
        init();
        setTitle("登录窗体");
        setSize(640,480);
        setLocationRelativeTo(null);
        //窗体大小不可变
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    //初始化方法
    private void init(){
        //设置字体类型，规则（加粗、倾斜）
        Font font = new Font("微软雅黑",Font.PLAIN,18);
        //账号文本
        accountLabel = new JLabel("账号");
        accountLabel.setFont(font);
        //账号输入
        accountField = new JTextField();
        accountField.setFont(font);
        //账号文本
        passwordLabel = new JLabel("密码");
        passwordLabel.setFont(font);
        //密码输入
        passwordField = new JPasswordField();
        passwordField.setFont(font);
        //角色文本
        roleLabel = new JLabel("角色");
        roleLabel.setFont(font);
        //选项
        String[] roles = {"教师","学生"};
        roleComboBox = new JComboBox<>(roles);
        roleComboBox.setFont(font);
        //添加按钮
        confirmButton = new JButton("确认");
        confirmButton.setFont(font);
        cancelButton = new JButton("取消");
        cancelButton.setFont(font);
        //窗体布局设置为空布局，需要给每个组件设置定位
        setLayout(null);
        //setBounds方法的四个参数分别组件x,y坐标，组件宽高
        accountLabel.setBounds(140,60,100,35);
        accountField.setBounds(240,60,260,35);
        passwordLabel.setBounds(140,130,100,35);
        passwordField.setBounds(240,130,260,35);
        roleLabel.setBounds(140,200,100,35);
        roleComboBox.setBounds(240,200,260,35);
        confirmButton.setBounds(160,300,100,40);
        cancelButton.setBounds(380,300,100,40);
        confirmButton.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
        cancelButton.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));
        //把所有组件添加进窗体
        add(accountLabel);
        add(accountField);
        add(passwordLabel);
        add(passwordField);
        add(roleLabel);
        add(roleComboBox);
        add(confirmButton);
        add(cancelButton);
        //最后加入背景图(因为背景图会覆盖上面的组件)
        bgLabel = new JLabel();
        Icon bgIcon = new ImageIcon(LoginFrame.class.getResource("/img/bg.jpg"));
        bgLabel.setIcon(bgIcon);
        bgLabel.setBounds(0,0,640,480);
        add(bgLabel);
    }
    //main方法
    public static void main(String[] args) {
        //使用系统样式，不适用皮肤效果
//        try{
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        new LoginFrame();

        //用beautyeye样式
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch (Exception e){
            e.printStackTrace();
        }
        new LoginFrame();
    }
}
