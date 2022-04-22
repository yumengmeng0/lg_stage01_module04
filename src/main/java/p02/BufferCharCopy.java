package p02;

import java.io.*;

/**
 * @author: ymm
 * @date: 2022/4/21
 * @version: 1.0.0
 * @description:
 */
public class BufferCharCopy {

    public static void main(String[] args) {

        String from = "E:\\test\\a.txt";
        String to = "E:\\test\\a-copy.txt";

        copy(from, to);


    }

    /**
     * 使用带缓存的输入输出流拷贝文件
     *
     * @param from
     * @param to
     */
    public static void copy(String from, String to) {

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(from));
            bufferedWriter = new BufferedWriter(new FileWriter(to));

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (bufferedWriter != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bufferedReader != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
