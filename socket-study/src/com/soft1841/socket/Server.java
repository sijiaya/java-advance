package com.soft1841.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server端程序（服务器）
 * 一个服务器对应多个客户端
 * 2019.5.6
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //创建服务器对象，映射端口8080
        ServerSocket ss = new ServerSocket(8080);
        System.out.println("服务器启动，端口号："+ss.getLocalPort());
        //服务器在8080端口进行监听
        while (true){
            //获得和客户端对象的连接
            Socket socket = ss.accept();
            System.out.println("客户端："+socket.getInetAddress()+"上线了");
            socket.close();
        }
    }
}
