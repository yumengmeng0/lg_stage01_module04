package p04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author: ymm
 * @date: 2022/4/29
 * @version: 1.0.0
 * @description: UDP发送端
 */
public class UDPSendTest {

    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        try {
            // 1.创建DatagramSocket类型对象
            datagramSocket = new DatagramSocket();
            // 2.创建DatagramPacket类型对象并提供接收方通信地址和端口号
            byte[] bytes = "hello".getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 8888);
            // 3.通过Socket发送Packet，调用send方法
            datagramSocket.send(datagramPacket);
            System.out.println("数据发送成功！");

            // 接收接收端回的消息
            byte[] bytes1 = new byte[128];
            DatagramPacket datagramPacket1 = new DatagramPacket(bytes1, bytes1.length);
            datagramSocket.receive(datagramPacket1);

            System.out.println("接收端回发的信息：" + new String(bytes1));

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
