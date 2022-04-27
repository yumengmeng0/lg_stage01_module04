package p03;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: ymm
 * @date: 2022/4/27
 * @version: 1.0.0
 * @description:
 */
public class ThreadCallableTest implements Callable {


    @Override
    public Object call() throws Exception {
        // 计算1-10000的和

        int sum = 0;
        for (int i = 1; i <= 10000; i++) {
            sum += i;
        }

        System.out.println("sum = " + sum);
        return sum;
    }


    public static void main(String[] args) {
        ThreadCallableTest threadCallableTest = new ThreadCallableTest();
        FutureTask futureTask = new FutureTask<>(threadCallableTest);

        Thread t1 = new Thread(futureTask);

        t1.start();

        Object obj = null;

        try {
            obj = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("线程处理结果 = " + obj);
    }


}
