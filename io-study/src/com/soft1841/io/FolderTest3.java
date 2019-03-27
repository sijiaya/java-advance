package com.soft1841.io;

import java.io.File;

/**
 * 在指定目录创建一个Java目录，并在内部创建chap1-10个子目录
 * 3.25
 */
public class FolderTest3 {
    public static void main(String[] args) {
        for (int i = 1;i<10;i++){
            File folder = new File("E:/java" + "/"+"chap" + i);
            if (!folder.exists()){
                folder.mkdirs();
            }else {
                folder.delete();
            }
        }
    }
}
