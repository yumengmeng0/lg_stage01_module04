package p02;

import java.io.*;

/**
 * @author: ymm
 * @date: 2022/4/20
 * @version: 1.0.0
 * @description:
 */
public class FileCharCopy {

    public static void main(String[] args) {
        copy(new File("E:\\test\\a.txt"), new File("E:\\test\\b.txt"));

    }

    /**
     * 文件字符流实现拷贝
     * 将from文件中是数据复制到偷文件中
     *
     * @param from
     * @param to
     */
    public static void copy(File from, File to) {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader(from);
            fileWriter = new FileWriter(to);

            int read = -1;
            while ((read = fileReader.read()) != -1) {
                fileWriter.write(read);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
