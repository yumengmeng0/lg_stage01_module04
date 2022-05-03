package p04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author: ymm
 * @date: 2022/4/28
 * @version: 1.0.0
 * @description:
 */
public class ClientStringTest2 {

    public static void main(String[] args) {
        Socket socket = null;
        PrintStream printStream = null;
        Scanner scanner = null;
        BufferedReader bufferedReader = null;


        try {
            // 1. 创建Socket类型的对象并提供服务器的主机名和端口号
            socket = new Socket("127.0.0.1", 8888);
            System.out.println("连接服务器成功！");

            // 2. 使用输入输出流进行通信
            // 客户端向服务器发送内容

            scanner = new Scanner(System.in);
            printStream = new PrintStream(socket.getOutputStream());
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            while (true) {
                System.out.println("请输入要发送的内容：");

                String str = scanner.next();
                printStream.println(str);

                System.out.println("客户端发送成功！");

                // 接收服务器发送的消息
                String s = bufferedReader.readLine();

                System.out.println("接收到的服务器消息：" + s);

                if ("bye".equals(str)) {
                    System.out.println("聊天结束！");
                    break;
                }


            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (printStream != null) {
                printStream.close();
            }

            // 3.关闭socket
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
