package com.soft1841.io;

import java.io.File;

/**
 * 在指定目录下创建一个upload目录，并在内部创建image、video、document、压缩包
 * 3.25
 */
public class FolderTest2 {
    public static void main(String[] args) {
        String[] strings ={"image","video","document","压缩包"};
        for (int i =0;i<strings.length;i++){
            File path = new File("E:/upload"+"/"+ strings[i]);
//            //当文件夹存在时删除文件夹
//            if (path.exists()){
//                path.delete();
//            }
            //当文件夹不存在时创建文件夹
            if (!path.exists()){
                path.mkdirs();
            }
        }
    }
}
