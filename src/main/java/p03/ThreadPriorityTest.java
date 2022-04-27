package p03;

/**
 * @author: ymm
 * @date: 2022/4/27
 * @version: 1.0.0
 * @description:
 */
public class ThreadPriorityTest extends Thread{

    @Override
    public void run() {
//        System.out.println("子线程优先级：" + getPriority()); // 5

        for (int i = 0; i < 20; i++) {
            System.out.println("1子线程 i = " + i);
        }

    }

    public static void main(String[] args) {
        ThreadPriorityTest threadPriorityTest = new ThreadPriorityTest();
        threadPriorityTest.start();

        Thread thread = Thread.currentThread();

//        System.out.println("主线程优先级：" + thread.getPriority()); // 5

        threadPriorityTest.setPriority(Thread.MAX_PRIORITY); // 优先级高的线程不一定先执行，只是时间片分的多
        for (int i = 0; i < 20; i++) {
            System.out.println("0主线程 i = " + i);
        }
    }

}
