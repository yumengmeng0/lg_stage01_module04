package p04;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author: ymm
 * @date: 2022/4/29
 * @version: 1.0.0
 * @description: 接收UDP协议发送的信息
 */
public class UDPReceiveTest {

    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;

        try {
            // 1.创建DatagramSocket类型对象并提供端口号
            datagramSocket = new DatagramSocket(8888);

            // 2.创建DatagramPacket类型对象并提供缓冲区
            byte[] bytes = new byte[128];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

            // 3.通过Socket接收数据内容存放到Packet里面，调用receive方法
            System.out.println("等待数据到来...");
            datagramSocket.receive(datagramPacket);
            System.out.println("接收到的数据内容是：" + new String(bytes));

            // 给发送方回消息
            byte[] bytes1 = "I receive".getBytes();
            DatagramPacket datagramPacket1 = new DatagramPacket(bytes1, bytes1.length, datagramPacket.getAddress(), datagramPacket.getPort());
            datagramSocket.send(datagramPacket1);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (datagramSocket != null) {
                // 4.关闭socket
                datagramSocket.close();
            }

        }

    }

}
