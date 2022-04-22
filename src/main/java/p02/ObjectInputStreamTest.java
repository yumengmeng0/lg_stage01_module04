package p02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author: ymm
 * @date: 2022/4/22
 * @version: 1.0.0
 * @description:
 */
public class ObjectInputStreamTest {

    public static void main(String[] args) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("E:\\test\\obj.txt"));
            Object object = ois.readObject();
            System.out.println("object = " + object);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
