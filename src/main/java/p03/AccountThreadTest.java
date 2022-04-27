package p03;

import java.util.concurrent.locks.Lock;

/**
 * @author: ymm
 * @date: 2022/4/27
 * @version: 1.0.0
 * @description:
 */
public class AccountThreadTest extends Thread {

    private int balance; // 账户余额

    private static Demo demo;

    public AccountThreadTest() {
    }

    public AccountThreadTest(int balance) {
        setBalance(balance);
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public synchronized void run() {
//        synchronized (demo) { // 必须是同一个对象
            // 1.模拟从后台查询余额
            int temp = getBalance();

            // 2.模拟取出200元的过程
            if (temp >= 200) {
                System.out.println("正在出钞，请稍后...");
                temp -= 200;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("请取走您的钞票！");
            } else {
                System.out.println("余额不足，请核对您的账户余额！");
            }

            // 3.模拟将最新的账户余额写入到后台
            setBalance(temp);
//        }

    }

    public static void main(String[] args) {
        AccountThreadTest t1 = new AccountThreadTest(1000);
        AccountThreadTest t2 = new AccountThreadTest(1000);

        t1.start();
        t2.start();

        System.out.println("主线程开始等待~");
        try {
            t1.join();
//            t2.start(); // 等待线程1取款结束后再启动线程2
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("账户余额： " + t1.getBalance());
        System.out.println("主线程结束~");

    }
}

