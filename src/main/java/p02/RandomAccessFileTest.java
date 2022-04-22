package p02;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author: ymm
 * @date: 2022/4/22
 * @version: 1.0.0
 * @description:
 */
public class RandomAccessFileTest {

    public static void main(String[] args) {
        RandomAccessFile file = null;

        try {
            file = new RandomAccessFile("e:/test/randomaccessfile.txt", "rw"); // hello

            file.seek(3);
            int read = file.read();
            System.out.println("read = " + (char)read);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (file != null) {

                try {
                    file.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }


}
