package com.soft1841.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class TestCopy2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一段字符串：" );
        String inputStream = scanner.nextLine();
        //1、通过字符流输出
        char[] chars = inputStream.toCharArray();
        //构造目标文件
        File destFile1 = new File("E:/字符串.txt");
        //(append)true是能够追加
        Writer out1 = new FileWriter(destFile1,true);
        out1.write(chars);
        out1.close();
    }
}
