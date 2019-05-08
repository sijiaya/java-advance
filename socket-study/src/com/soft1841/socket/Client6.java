package com.soft1841.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.UUID;

/**
 * 服务器向客户端发送非文本数据
 * 客户端
 */
public class Client6 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1",12000);
        System.out.println("成功连上服务器");
        //客户端读入数据
        InputStream inputStream = client.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        System.out.println("请输入需要保存的路径：");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        File file = new File(path+"/"+ UUID.randomUUID().toString()+".jpg");
        OutputStream outputStream = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(outputStream);
        byte[] data = new byte[1024];
        int tmp;
        while ((tmp = bis.read(data)) != -1){
            bos.write(data,0,tmp);
        }
        bos.close();
        bis.close();
        client.close();
    }
}
