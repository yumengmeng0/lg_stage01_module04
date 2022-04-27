package p03;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: ymm
 * @date: 2022/4/26
 * @version: 1.0.0
 * @description:
 */
public class ThreadSleepTest extends Thread{

    @Override
    public void run() {
        // 每隔一秒获取一次系统时间

        while (true) {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(simpleDateFormat.format(date));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        ThreadSleepTest sleepTest = new ThreadSleepTest();
        sleepTest.start();

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        sleepTest.stop();
    }
}
