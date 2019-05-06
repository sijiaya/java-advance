package com.soft1841.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * 服务器向客户端发送文本数据
 */
public class Server1 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(12580);
        System.out.println("服务器启动");
        OutputStream out;
        String info = "I Love Java";
        while (true){
            Socket socket = ss.accept();
            System.out.println(socket.getInetAddress()+"上线了");
            //根据客户端对象获取输出流对象
            out = socket.getOutputStream();
            out.write(info.getBytes());
            out.close();
            socket.close();
        }
    }
}
