package p04;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: ymm
 * @date: 2022/4/28
 * @version: 1.0.0
 * @description: 单线程服务端
 */
public class ServerStringTest {

    public static void main(String[] args) {
        // 1.创建ServerSocket类型的对象并提供端口号
        ServerSocket serverSocket = null;
        Socket socket = null;

        BufferedReader bufferedReader = null;
        PrintStream printStream = null;

        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("等待客户端的连接请求...");

            // 没有客户端连接时，服务器阻塞在accept方法的调用这里
            socket = serverSocket.accept();

            System.out.println("客户端 " + socket.getInetAddress() + " 连接成功！");

            // 3.使用输入输出流进行通信
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printStream = new PrintStream(socket.getOutputStream());

            while (true) {
                // 当没有客户端消息时，会阻塞
                // 打印接收到的客户端信息

                String s = bufferedReader.readLine();
                System.out.println("接收到的客户端信息：" + s);

                // 服务器向客户端发送消息
                printStream.println("I received");
                System.out.println("服务器发送消息成功！");

                // 当客户端发来的内容为“bye”时，结束聊天
                if ("bye".equals(s)) {
                    System.out.println("聊天结束！");
                    break;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (printStream != null) {
                printStream.close();
            }

            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

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
