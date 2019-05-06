package com.soft1841.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 服务端接收客户端文本数据
 */
public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(" 10.40.203.82",10086);
        //获取客户端的输出流
        OutputStream out = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要发给服务器的内容：");
        String info = scanner.nextLine();
        out.write(info.getBytes());
        out.close();
        socket.close();
    }
}
