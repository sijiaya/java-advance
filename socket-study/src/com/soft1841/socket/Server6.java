package com.soft1841.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器向客户端发送非文本数据
 * 服务器端
 */
public class Server6 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12000);
        System.out.println("服务器启动......");
        while (true){
            Socket socket = serverSocket.accept();
            ServerThread6 server = new ServerThread6(socket);
            new Thread(server).start();
        }
    }
}
class ServerThread6 implements Runnable{

    private Socket socket;
    public ServerThread6(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("客户端："+socket.getInetAddress()+"连接成功");
        try {
            File file = new File("D:/bg.jpg");
            InputStream inputStream = new FileInputStream(file);
            byte[] b = new byte[(int) file.length()];
            inputStream.read(b);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(b);
            inputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}