package p02;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author: ymm
 * @date: 2022/4/22
 * @version: 1.0.0
 * @description:
 */
public class DataInputStreamTest {

    public static void main(String[] args) {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("E:\\test\\data.txt"));
            int i = dis.readInt(); // 读取4个字节
//            int i = dis.read(); // 读取1个字节
            System.out.println("i = " + i);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
