package p01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: ymm
 * @date: 2022/4/18
 * @version: 1.0.0
 * @description:
 */
public class ExceptionThrowsTest {

    public static  void show() throws IOException {
        FileInputStream fis = new FileInputStream("d:/a.txt");
        fis.close();
    }

    public static void main(String[] args) {

        try {
            show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
