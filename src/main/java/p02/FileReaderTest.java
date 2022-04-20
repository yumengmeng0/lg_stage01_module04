package p02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author: ymm
 * @date: 2022/4/20
 * @version: 1.0.0
 * @description:
 */
public class FileReaderTest {

    public static void main(String[] ars) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("E:/test/a.txt");
            int read;

            while (( read = fileReader.read()) != -1) {
                System.out.println("read = " + (char)read);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (fileReader!=null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}
