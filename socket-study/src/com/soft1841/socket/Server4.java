package com.soft1841.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/**
 * 客户端向服务器发送非文本数据（图片）
 * 服务器端
 */
public class Server4 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10010);
        System.out.println("服务器启动......");
        while (true){
            Socket socket = serverSocket.accept();
            ServerThread4 server = new ServerThread4(socket);
//            Thread thread = new Thread(server);
//            thread.start();
            new Thread(server).start();
        }
    }
}
 class ServerThread4 implements Runnable{
    private Socket socket;

    public ServerThread4(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("客户端"+ socket.getInetAddress()+"连接成功");
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            String path = System.getProperty("user.dir");
            //写到服务器指定路径
//            File file = new File("D:/img/"+ UUID.randomUUID().toString()+".jpg");
            File file = new File(path+"\\socket-study\\src\\img\\"+ UUID.randomUUID().toString() + ".jpg");
            OutputStream os = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            //缓冲区
            byte[] data = new byte[1024];
            int tmp;
            //每次循环从输入流读取缓冲区大小的字节，立刻通过输出流写出去
            while ((tmp = bis.read(data))!= -1){
                bos.write(data,0,tmp);
            }
            bos.close();
            bis.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
