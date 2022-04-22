package p02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author: ymm
 * @date: 2022/4/22
 * @version: 1.0.0
 * @description:
 */
public class ObjectOutputStreamTest  {

    public static void main(String[] args) {

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("E:\\test\\obj.txt"));
            Person zhangsan = new Person("zhangsan", 11);

            oos.writeObject(zhangsan);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
