package p01;

import java.io.File;

/**
 * @author: ymm
 * @date: 2022/4/20
 * @version: 1.0.0
 * @description:
 */
public class FileListTest {


    public static void main(String[] args) {

        File file = new File("E:/test");


        listAllFiles(new File("E:/test"));
    }


    /**
     * 指定目录中所有内容的打印
     *
     * @param file
     */
    public static void listAllFiles(File file) {

        if (file.exists()) {
            File[] files = file.listFiles();
            for (File f : files) {

                String name = f.getName();
                // 打印文件夹名
                if (f.isDirectory()) {
                    System.out.println("[" + name + "]");
                    listAllFiles(f);
                    System.out.println(" ==== " );
                }

                // 打印文件名
                if (f.isFile()) {
                    System.out.println(name);
                }
            }
        }

    }
}
