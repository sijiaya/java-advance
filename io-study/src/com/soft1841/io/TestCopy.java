package com.soft1841.io;

import java.io.*;

/**
 * txt文本复制操作
 * 3.26
 */
public class TestCopy {
    public static void main(String[] args) throws IOException {
        File srcFile = new File("E:/hello.txt");
        if (srcFile.exists()){
            File destFile = new File("E:/hello副本.txt");
            Reader in  = new FileReader(srcFile);
            //准备字符数组
            char[] chars = new char[(int) srcFile.length()];
            //把srcFile通过char读到数组中
            in.read(chars);
            Writer out = new FileWriter(destFile);
            out.write(chars);
            in.close();
            out.close();
        }else {
            System.out.println("文件不存在");
        }
    }
}
