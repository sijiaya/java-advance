package com.soft1841.io;

import java.io.File;
import java.io.IOException;

public class FileDemo1 {
    public static void main(String[] args) throws IOException {
        //创建文件对象
        File file = new File("E:/README.md");
        //文件不存在(程序第一次运行时，执行的语句块)
        if (!file.exists()){
            file.createNewFile();
        }
    }
}
