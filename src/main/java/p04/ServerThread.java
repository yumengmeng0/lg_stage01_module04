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
 * @description: 服务端线程
 */
public class ServerThread extends Thread {

    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        BufferedReader bufferedReader = null;
        PrintStream printStream = null;

        try {
            // 3.使用输入输出流进行通信
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printStream = new PrintStream(socket.getOutputStream());

            while (true) {
                // 当没有客户端消息时，会阻塞
                // 打印接收到的客户端信息

                String s = bufferedReader.readLine();
                System.out.println("接收到的客户端[" + socket.getInetAddress() + "]信息：" + s);

                // 服务器向客户端发送消息
                printStream.println("I received");
                System.out.println("服务器发送消息成功！");

                // 当客户端发来的内容为“bye”时，结束聊天
                if ("bye".equals(s)) {
                    System.out.println("聊天结束！");
                    System.out.println("客户端 " + socket.getInetAddress() + " 下线！");
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

        }

    }

}
