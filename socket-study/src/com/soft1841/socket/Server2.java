package com.soft1841.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端向服务器发送文本数据
 */
public class Server2 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10086);
        System.out.println("服务器启动");
        InputStream in;
        while (true){
            Socket socket = ss.accept();
            System.out.println(socket.getInetAddress()+"上线了");
            in = socket.getInputStream();
            byte[] b = new byte[1024];
            in.read(b);
            System.out.println(socket.getInetAddress()+"发送的信息为："+new String(b));
        }
    }
}
