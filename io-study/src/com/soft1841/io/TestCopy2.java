package com.soft1841.io;

import java.io.*;
import java.util.Scanner;

public class TestCopy2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一段字符串：" );
        String inputString = scanner.nextLine();
        //1、通过字符流输出
        char[] chars = inputString.toCharArray();
        //构造目标文件
        File destFile1 = new File("E:/result1.txt");
        //(append)true是能够追加
        Writer out1 = new FileWriter(destFile1,true);
        out1.write(chars);
        out1.close();
        //2、通过字节流输出
        byte[] bytes = inputString.getBytes();
        File destFile2 = new File("E:/result2.txt");
        OutputStream  out2 = new FileOutputStream(destFile2);
        out2.write(bytes);
        out2.close();
        //3、通过打印流输出
        File destFile3 = new File("E:/result3.txt");
        OutputStream out3 = new FileOutputStream(destFile3);
        PrintStream printStream = new PrintStream(out3);
        printStream.println(inputString);
        out3.close();
    }
}
