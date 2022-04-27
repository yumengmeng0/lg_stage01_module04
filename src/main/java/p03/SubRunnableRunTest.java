package p03;

/**
 * @author: ymm
 * @date: 2022/4/25
 * @version: 1.0.0
 * @description:
 */
public class SubRunnableRunTest {
    public static void main(String[] args) {
        SubRunnableRun subRunnableRun = new SubRunnableRun();

        // 经过构造方法的调用之后，Thread类中的成员变量target的数值为subRunnableRun
        Thread t1 = new Thread(subRunnableRun);

        // 使用Runnable引用构造了线程对象，调用该方法（run）时最终调用接口中的版本
        t1.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("[main]i = " + i);
        }
    }
}
