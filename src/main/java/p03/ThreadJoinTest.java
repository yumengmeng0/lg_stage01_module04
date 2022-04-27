package p03;

/**
 * @author: ymm
 * @date: 2022/4/27
 * @version: 1.0.0
 * @description:
 */
public class ThreadJoinTest extends Thread {

    @Override
    public void run() {
        System.out.println("倒计时开始！");
        for (int i = 5; i > 0; i--) {
            System.out.println("i = " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("倒计时结束！");
    }

    public static void main(String[] args) {
        ThreadJoinTest threadJoinTest = new ThreadJoinTest();
        threadJoinTest.start();

        System.out.println("主线程开始等待~");
        try {
            // 表示当前正在执行的线程对象等待调用线程对象，也就是主线程等待子线程终止
//            threadJoinTest.join();
            threadJoinTest.join(3000); // 最多等待3s，主线程结束，子线程还在继续执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程结束~");
    }
}
