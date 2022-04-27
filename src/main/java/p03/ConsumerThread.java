package p03;

/**
 * @author: ymm
 * @date: 2022/4/27
 * @version: 1.0.0
 * @description:
 */
public class ConsumerThread extends Thread {

    private StoreHouse storeHouse;


    // 为了确保两个线程共用一个仓库
    public ConsumerThread(StoreHouse storeHouse) {
        this.storeHouse = storeHouse;
    }

    @Override
    public void run() {

        while (true) {
            storeHouse.consumeProduct();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
