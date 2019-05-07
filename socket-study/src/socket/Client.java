package socket;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        //创建客户端对象指定连接的服务器IP和端口
        Socket client = new Socket("127.0.0.1",10086);
        System.out.println("成功连上服务器");
        Thread.sleep(1000);
        client.close();
    }
}
