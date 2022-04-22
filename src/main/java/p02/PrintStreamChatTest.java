package p02;

import java.io.*;

/**
 * @author: ymm
 * @date: 2022/4/21
 * @version: 1.0.0
 * @description:
 */
public class PrintStreamChatTest {
    public static void main(String[] args) {

        BufferedReader bufferedReader = null;
        PrintStream printStream = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            printStream = new PrintStream(new FileOutputStream("e:\\test\\chatroom.txt"));

            while (true) {
                // 1.提示用户输入聊天内容
                System.out.println("请输入聊天内容：");
                String s = bufferedReader.readLine();
                // 2.判断用户输入的内容是否为“bye”，是的话结束聊天
                if ("bye".equals(s)) {
                    System.out.println("聊天结束");
                    break;
                } else {
                    // 3.若不是，将输入的内容保存到文件中
                    printStream.println(s);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
