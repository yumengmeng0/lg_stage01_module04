package p03;

/**
 * @author: ymm
 * @date: 2022/4/25
 * @version: 1.0.0
 * @description:
 */
public class SubThreadRun extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("[SubThreadRun]i = " + i);
        }
    }
}
