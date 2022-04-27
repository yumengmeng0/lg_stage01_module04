package p03;

/**
 * @author: ymm
 * @date: 2022/4/26
 * @version: 1.0.0
 * @description:
 */
public class RunnableIdNameTest implements Runnable{

    @Override
    public void run() {
        // 获取当前正在执行的线程的引用，即子线程的引用
        Thread thread = Thread.currentThread();
        System.out.println("子线程的id：" + thread.getId() + "，子线程的名字：" + thread.getName());
    }

    public static void main(String[] args) {
        RunnableIdNameTest runnableIdNameTest = new RunnableIdNameTest();
        Thread thread = new Thread(runnableIdNameTest);
        thread.start();

        // 获取当前正在执行线程的引用，主线程的引用
        Thread main = Thread.currentThread();
        System.out.println("主线程id：" + main.getId() + "，主线程名字：" + main.getName());
    }
}
