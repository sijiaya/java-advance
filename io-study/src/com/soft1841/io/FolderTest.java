package com.soft1841.io;

import java.io.File;
import java.io.IOException;

public class FolderTest {
    public static void main(String[] args) throws IOException {
        //创建新目录
        File path = new File("E:/my_file");
        //文件不存在
        if (!path.exists()){
            path.mkdirs();
        }
        //创建文件对象
        File file = new File(path+"/"+"hello_251635.txt");
        if (!file.exists()){
            try {
                file.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }//创建该文件
        }
    }
}
