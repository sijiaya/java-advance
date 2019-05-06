package com.soft1841.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 客户端接收服务端文本数据
 */
public class Client1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("10.40.203.82",12580);
        //获取客户端的输入流
        InputStream in = socket.getInputStream();
        byte[] b = new byte[1024];
        in.read(b);
        System.out.println("服务端发送的数据是："+new String(b));
        in.close();
        socket.close();
    }
}
