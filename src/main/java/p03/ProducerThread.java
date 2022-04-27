package p03;

/**
 * @author: ymm
 * @date: 2022/4/27
 * @version: 1.0.0
 * @description:
 */
public class ProducerThread extends Thread {

    // 声明一个仓库类型的引用作为成员变量，为了调用仓库的成员方法  合成复用原则
    private StoreHouse storeHouse;

    public ProducerThread(StoreHouse storeHouse) {
        this.storeHouse = storeHouse;
    }

    @Override
    public void run() {

        while (true) { // 持续生产
            storeHouse.produceProduct();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
