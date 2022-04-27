package p03;

/**
 * @author: ymm
 * @date: 2022/4/27
 * @version: 1.0.0
 * @description:
 */
public class SubThread1 extends Thread {

    @Override
    public void run() {
        // 打印1-100之间所有奇数
        for (int i = 1; i <= 100; i += 2) {
            System.out.println("子线程1 中 i = " + i);
        }
    }
}
