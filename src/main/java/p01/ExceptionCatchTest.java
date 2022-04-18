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
public class ExceptionCatchTest {

    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("d:/a.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) { // 如果不捕获 NullPointerException 下面的打印语句不会执行
            e.printStackTrace();
        }


        System.out.println("程序结束");

        // 手动处理异常和没有处理异常的区别：代码是否可以继续向下执行

    }

}
