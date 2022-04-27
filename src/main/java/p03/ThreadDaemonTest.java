package p03;

/**
 * @author: ymm
 * @date: 2022/4/27
 * @version: 1.0.0
 * @description:
 */
public class ThreadDaemonTest extends Thread {

    @Override
    public void run() {

        System.out.println(isDaemon() ? "是守护线程" : "不是守护线程");
        // 当子线程不是守护线程时，主线程结束后，子线程会继续执行，直到子线程结束
        // 当子线程是守护线程时，主线程结束后，子线程随之结束
        for (int i = 0; i < 50; i++) {
            System.out.println("    子线程 i = " + i);
        }
    }

    public static void main(String[] args) {

        ThreadDaemonTest threadDaemonTest = new ThreadDaemonTest();


        threadDaemonTest.setDaemon(true); // 必须在线程启动之前设置
        threadDaemonTest.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("主线程 i = " + i);
        }
    }
}
