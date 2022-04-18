package p01;

/**
 * @author: ymm
 * @date: 2022/4/18
 * @version: 1.0.0
 * @description:
 */
public class ExceptionFinallyTest {

    public static int test() {
        try {
            int[] arr = new int[5];
            System.out.println("arr[5] = " + arr[5]);
            return 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return 1;
        } finally {
            return 2;
        }
    }

    public static void main(String[] args) {

        try {
            int ia = 10;
            int ib = 0;

            System.out.println("ia/ib = " + ia / ib);
        } catch (ArithmeticException e) {
            e.printStackTrace();

            String s = null;
//            s.length(); // 发生空指针异常
        } finally {
            System.out.println("无论是否发生异常，都会执行");
        }

        System.out.println("程序结束");
        System.out.println("test() = " + test());

    }
}
