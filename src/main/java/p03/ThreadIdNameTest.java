package p03;

/**
 * @author: ymm
 * @date: 2022/4/26
 * @version: 1.0.0
 * @description:
 */
public class ThreadIdNameTest extends Thread{


    public ThreadIdNameTest() {
    }

    public ThreadIdNameTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("子线程的id：" + getId() + "，子线程的名字：" + getName());
    }

    public static void main(String[] args) {
        ThreadIdNameTest t1 = new ThreadIdNameTest();
        t1.start();

        ThreadIdNameTest t2 = new ThreadIdNameTest("线程名");
        t2.start();

        // 获取当前正在执行线程的引用，主线程的引用
        Thread thread = Thread.currentThread();
        System.out.println("主线程id：" + thread.getId() + "，主线程名字：" + thread.getName());

    }
}
