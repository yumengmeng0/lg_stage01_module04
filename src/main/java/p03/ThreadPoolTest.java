package p03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: ymm
 * @date: 2022/4/27
 * @version: 1.0.0
 * @description:
 */
public class ThreadPoolTest {

    public static void main(String[] args) {

        // 1.创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // 2.向线程池中布置任务

        executorService.submit(new ThreadCallableTest());

        // 3.关闭线程池
        executorService.shutdown();

    }
}
