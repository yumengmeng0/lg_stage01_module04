package p02;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author: ymm
 * @date: 2022/4/20
 * @version: 1.0.0
 * @description:
 */
public class FileWriterTest {

    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try {
            // 构造FileWriter类型对象与文件关联
            // 若文件存在，该流会情况文件中原有的内容
            // 若文件不存在，该流会创建新的空文件
//            fileWriter = new FileWriter("E:/test/a.txt");
            // 以追加的方式关联文件
            fileWriter = new FileWriter("E:/test/a.txt", true);

            // 通过流对象写入数据
            fileWriter.write("world");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    // 关闭流对象并释放相关资源
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
