package p03;

/**
 * @author: ymm
 * @date: 2022/4/27
 * @version: 1.0.0
 * @description: 线程之间通信
 */
public class ThreadCommunicateTest implements Runnable {

    private int cnt = 1;

    @Override
    public void run() {

        while (true) {
            synchronized (this) {
                // 每当一个线程进来后，调用notify方法，唤醒其他线程
                notify();
                if (cnt <= 100) {
                    System.out.println("线程" + Thread.currentThread().getName() + ", cnt = " + cnt);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    cnt++;

                    // 当前线程打印完毕一个整数后，为了防止继续打印下一个数据，调用wait方法
                    try {
                        wait(); // 当前线程进入阻塞状态，自动释放对象锁，必须在锁定的代码块中调用
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }

    }

    public static void main(String[] args) {
        ThreadCommunicateTest r = new ThreadCommunicateTest();

        Thread t1 = new Thread(r);
        t1.start();

        Thread t2 = new Thread(r);
        t2.start();


    }
}
