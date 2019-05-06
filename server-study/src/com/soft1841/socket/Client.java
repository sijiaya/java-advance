package com.soft1841.socket;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //创建客户端对象，指定连续的服务器IP和端口
        Socket socket = new Socket("172.20.10.2",10086);
        System.out.println("已和服务器创建连接，远程主机地址："+socket.getRemoteSocketAddress());
    }
}
