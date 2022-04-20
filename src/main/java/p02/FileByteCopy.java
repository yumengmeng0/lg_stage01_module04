package p02;

import java.io.*;

/**
 * @author: ymm
 * @date: 2022/4/20
 * @version: 1.0.0
 * @description:
 */
public class FileByteCopy {

    public static void main(String[] args) {

        String from = "E:\\test\\YU.JPG";  // 不区分大小写
        String to = "E:\\test\\yu01.jpg";
        String to2 = "E:\\test\\yu02.jpg";
        String to3 = "E:\\test\\yu03.jpg";
        copy(from, to);
        copy2(from, to2);
        copy2(from, to3);

    }


    /**
     * 方式一：单字节拷贝，拷贝大文件效率低
     * 字节流拷贝
     *
     * @param from 被拷贝的文件路径
     * @param to   拷贝到的文件路径
     */
    public static void copy(String from, String to) {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(from);
            fos = new FileOutputStream(to);

            int read = 0;
            try {
                while ((read = fis.read()) != -1) {
                    fos.write(read);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    /**
     * 方式二：用和文件一样大小的缓冲区一次性拷贝文件
     * 字节流拷贝
     *
     * @param from 被拷贝的文件路径
     * @param to   拷贝到的文件路径
     */
    public static void copy2(String from, String to) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(from);
            fos = new FileOutputStream(to);

            int available = fis.available();

            byte[] buff = new byte[available];

//            int read = 0;
            try {
                while (fis.read(buff) != -1) {
                    fos.write(buff);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * 方式三：准备一个合适的缓冲区拷贝
     * 字节流拷贝
     *
     * @param from 被拷贝的文件路径
     * @param to   拷贝到的文件路径
     */
    public static void copy3(String from, String to) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(from);
            fos = new FileOutputStream(to);

            byte[] buff = new byte[1024];

            int read = 0;
            try {
                while ((read = fis.read(buff)) != -1) {
                    fos.write(buff, 0, read);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
