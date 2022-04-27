package p03;

/**
 * @author: ymm
 * @date: 2022/4/27
 * @version: 1.0.0
 * @description:
 */
public class StoreHouseTest {

    public static void main(String[] args) {
        StoreHouse storeHouse = new StoreHouse();

        Thread producer = new ProducerThread(storeHouse);
        Thread consumer = new ConsumerThread(storeHouse);

        producer.start();
        consumer.start();
    }

}
