package com.soft1841.swing;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutPoem extends JFrame {
    public FlowLayoutPoem(){
        //设置窗体标题
        setTitle("古诗题");
        Container c = getContentPane();
        //设置创立使用流布局管理器，使用组件居中对齐
        setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        //在容器中循环添加4个按钮
            c.add(new JButton("下面四句诗，哪一句是描写夏天的？"));
            c.add(new JButton("A.秋风萧瑟天气凉，草木摇荡露为霜"));
            c.add(new JButton("B.白雪纷纷何所似，撒盐空中差可拟"));
            c.add(new JButton("C.接天莲叶无穷碧，映日荷花别样红"));
            c.add(new JButton("D.竹外桃花三两枝，春江水暖鸭先知"));
        //设置窗体关闭方式
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //设置窗体大小
        setSize(400,300);
        //设置窗体可见
        setVisible(true);
    }
    public static void main(String[] args) {
        new FlowLayoutPoem();
    }
}
