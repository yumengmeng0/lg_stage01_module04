package p03;

/**
 * @author: ymm
 * @date: 2022/4/25
 * @version: 1.0.0
 * @description:
 */
public class SubThreadRunTest {

    public static void main(String[] args) {
        SubThreadRun t1 = new SubThreadRun();

        // 调用run方法，本质上是普通方法的调用，执行流程就是run方法的代码执行完毕后才能继续向下执行
        // 没有启动新线程
//        t1.run();
        // 用于启动线程，Java虚拟机会自动调用该了类线程中的run方法。
        // 又启动了一个线程
        t1.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("[main]i = " + i);
        }
    }

}
