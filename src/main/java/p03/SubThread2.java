package p03;

/**
 * @author: ymm
 * @date: 2022/4/27
 * @version: 1.0.0
 * @description:
 */
public class SubThread2 extends Thread {

    @Override
    public void run() {
        // 打印1-100之间所有偶数
        for (int i = 2; i <= 100; i += 2) {
            System.out.println("子线程2 中 i = " + i);
        }
    }
}
