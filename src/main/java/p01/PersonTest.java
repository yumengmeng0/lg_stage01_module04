package p01;

/**
 * @author: ymm
 * @date: 2022/4/18
 * @version: 1.0.0
 * @description:
 */
public class PersonTest {

    public static void main(String[] args) {
        Person zhangfei = null;
        try {
            zhangfei = new Person("zhangfei", -1);
        } catch (AgeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("zhangfei = " + zhangfei);
    }
}
