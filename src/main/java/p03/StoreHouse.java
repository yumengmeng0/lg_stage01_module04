package p03;

/**
 * @author: ymm
 * @date: 2022/4/27
 * @version: 1.0.0
 * @description: 仓库
 */
public class StoreHouse {

    private int cnt = 0; // 仓库里面的产品数量

    public synchronized void produceProduct() {
        notify();
        if (cnt <= 10) {
            System.out.println("线程" + Thread.currentThread().getName() + "正在生产第" + (++cnt) + "个产品");
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumeProduct() {
        notify();
        if (cnt > 0) {
            System.out.println("线程" + Thread.currentThread().getName() + "正在消费第" + (cnt--) + "个产品");
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
