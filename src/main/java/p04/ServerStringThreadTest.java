package p04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: ymm
 * @date: 2022/4/28
 * @version: 1.0.0
 * @description: 多线程服务端
 */
public class ServerStringThreadTest {

    public static void main(String[] args) {
        // 1.创建ServerSocket类型的对象并提供端口号
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(8888);

            while (true) {

                System.out.println("等待客户端的连接请求...");

                // 没有客户端连接时，服务器阻塞在accept方法的调用这里
                socket = serverSocket.accept();
                System.out.println("客户端 " + socket.getInetAddress() + " 连接成功！");

                new ServerThread(socket).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
