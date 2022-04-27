package p03;

/**
 * @author: ymm
 * @date: 2022/4/25
 * @version: 1.0.0
 * @description:
 */
public class ThreadTest {

    public static void main(String[] args) {
        Thread thread = new Thread();
        // 由源码可知，Thread类中的成员变量target的数值是null
        thread.run();

        System.out.println("thread test");
    }
}
