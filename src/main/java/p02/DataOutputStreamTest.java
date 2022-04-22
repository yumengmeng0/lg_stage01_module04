package p02;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: ymm
 * @date: 2022/4/22
 * @version: 1.0.0
 * @description:
 */
public class DataOutputStreamTest {

    public static void main(String[] args) {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("E:\\test\\data.txt"));
            // 66 : 0000 0000 ...  0100 0010 "   B"
            int n = 66;
            dos.writeInt(n); // 写入4个字节
//            dos.write(n); // 写入1个字节

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
