package p02;

import java.io.*;

/**
 * @author: ymm
 * @date: 2022/4/21
 * @version: 1.0.0
 * @description: 带缓冲区的输入输出流
 */
public class BufferedByteCopy {

    public static void main(String[] args) {

        String from = "E:\\test\\yu.jpg";
        String to = "E:\\test\\yu-buf.jpg";

        long start = System.currentTimeMillis();

        copy(from, to);

        long end = System.currentTimeMillis();
        System.out.println("使用缓冲流拷贝文件的时间：" + (end - start) + " ms");

    }

    /**
     * 使用缓存流拷贝文件
     *
     * @param from
     * @param to
     */
    public static void copy(String from, String to) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(new FileInputStream(from));
            bos = new BufferedOutputStream(new FileOutputStream(to));

            int read = 0;
            while ((read = bis.read()) != -1) {
                bos.write(read);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
