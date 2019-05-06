package com.soft1841.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端向服务器端发送发送文本数据——控制台版本
 * server服务器端
 */
public class Server3 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12000);
        System.out.println("服务器启动");
        while (true){
            Socket socket = serverSocket.accept();
            ServerThread3 serverThread3 = new ServerThread3(socket);
            new Thread(serverThread3).start();
        }
    }
}
