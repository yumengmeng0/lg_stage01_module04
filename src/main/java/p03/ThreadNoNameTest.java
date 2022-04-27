package p03;

/**
 * @author: ymm
 * @date: 2022/4/26
 * @version: 1.0.0
 * @description:
 */
public class ThreadNoNameTest {

    public static void main(String[] args) {
        // 1.使用继承加匿名内部类的方式创建并 启动线程

        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread");
            }
        };

        t1.start();

        // 2.使用实现接口加内部类的方式创建并启动线程
        Runnable r =  new Runnable(){

            @Override
            public void run() {
                System.out.println("Runnable");
            }
        };

        new Thread(r).start();
    }


}
