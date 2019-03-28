package com.soft1841.swing;

import javax.swing.*;
import java.awt.*;

/**
 * GridLayout网格布局实例
 * @author sijia
 * 2019.3.27
 */
public class GridLayoutTest extends JFrame {
    //定义一个面板数组
    private JPanel[] panels;
    //标签，用来容纳图片
    private JLabel imgLabel;
    //用来接收图片
    private Icon icon;
    private GridLayoutTest() {
        //调用init
        init();
        setTitle("GridLayout网格布局管理器");
        //界面启动最大化
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //窗体可见
        setVisible(true);
        //关闭进程
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    //初始化组件（设置布局，放置组件）
    public void init() {
        //将整个容器背景置为白色
        getContentPane().setBackground(new Color(255, 255, 255));
        //定义三行三列九宫格，放置9个面板
        GridLayout gridLayout = new GridLayout(3, 3, 50, 30);
        setLayout(gridLayout);
        //创建面板数组
        panels = new JPanel[9];
        //循环创建每个面板对象
        for (int i = 0; i < 9; i++) {
            panels[i] = new JPanel();
            //面板加上边框
            panels[i].setBorder(BorderFactory.createTitledBorder("面板" +
                    (i + 1)));
            //面板依次加入网格布局管理器，变成九宫格
            add(panels[i]);
        }

        //1、设置第一个面板背景色，其布局方式默认为FlowLayout居中对齐
        panels[0].setBackground(new Color(172, 72, 62));
        //在第一个面板内部加5个按钮
        for (int i = 0; i < 5; i++) {
            panels[0].add(new JButton("Java"));
        }
        //2、设置第二个面板为BorderLayout边界布局，设置背景色
        panels[1].setLayout(new BorderLayout(20, 20));
        panels[1].setBackground(new Color(24, 160, 94));
        //5个方向加入按钮
        panels[1].add(new JButton("北"), BorderLayout.NORTH);
        panels[1].add(new JButton("南"), BorderLayout.SOUTH);
        panels[1].add(new JButton("东"), BorderLayout.EAST);
        panels[1].add(new JButton("西"), BorderLayout.WEST);
        panels[1].add(new JButton("中"), BorderLayout.CENTER);

        //3、设置第三个面板为GridLayout网格布局，设置背景色
        panels[2].setLayout(new GridLayout(3, 3, 10, 10));
        panels[2].setBackground(new Color(255, 205, 66));
        //依次加入9个按钮
        for (int i = 0; i < 9; i++) {
            panels[2].add(new JButton(String.valueOf(i + 1)));
        }

        //4、设置第四个面板(6行5列，间距5个像素)
        panels[3].setLayout(new GridLayout(2, 1, 15, 15));
        panels[3].setBackground(new Color(74, 138, 244));
        for (int i = 0; i < 2; i++) {
            panels[3].add(new JButton(String.valueOf(i + 1)));
        }
        //5、设置第五个面板(1行3列)
        panels[4].setLayout(new GridLayout(1, 3, 10, 10));
        panels[4].setBackground(new Color(225, 96, 21));
        for (int i = 0; i < 4; i++) {
            panels[4].add(new JButton(String.valueOf(i + 1)));
        }
        //6、设置第六个面板
        panels[5].setLayout(new GridLayout(1, 2, 10, 10));
        panels[5].setBackground(new Color(24, 160, 94));
        for (int i = 0; i < 2; i++) {
            panels[5].add(new JButton(String.valueOf(i + 1)));
        }


        //7、设置第七个面板
        panels[6].setBackground(new Color(255, 205, 66));
        String[] contents = {"1", "2", "3", "4", "5"};
        JList<String> jList = new JList<>(contents);
        JScrollPane jScrollPane = new JScrollPane(jList);
        jScrollPane.setBounds(100, 30, 75, 22);
        panels[6].add(jScrollPane);
        //8、设置第八个面板
        panels[7].setBackground(new Color(74, 138, 244));
        JTextArea textArea = new JTextArea(10,30);
        JScrollPane jScrollPane1 = new JScrollPane(textArea);
        panels[7].add(jScrollPane1);
        //9、设置第九个面板
        panels[8].setBackground(new Color(225, 96, 21));
        JLabel jLabel = new JLabel("这是一个窗体", JLabel.CENTER);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setOpaque(true);
        panels[8].add(jLabel);
    }


    public static void main(String[] args) {
        //用系统样式替代Swing默认样式
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (Exception e){
            e.printStackTrace();
        }
        new GridLayoutTest();
    }
}
