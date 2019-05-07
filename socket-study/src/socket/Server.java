package socket;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);
        System.out.println("服务器启动");
        Socket socket;
        //记录客户端的数量
        int count = 0;
        while (true){
            while (true){
                socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                new Thread(serverThread).start();
                count++;
                System.out.println("当前客户端连接的数量"+count);
            }
        }
    }
}

class ServerThread implements Runnable{
    private Socket socket;

//    public void setSocket(Socket socket) {
//        this.socket = socket;
//    }
    public ServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("客户端"+socket.getInetAddress()+"连接成功");
    }
}
