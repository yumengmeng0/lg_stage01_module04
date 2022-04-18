package p01;

/**
 * @author: ymm
 * @date: 2022/4/18
 * @version: 1.0.0
 * @description:
 */
public class ExceptionTest {
    public static void main(String[] args) {

        // 非检测性异常，运行时异常
        // 编译成功，运行时发生算数异常，下面一句不会执行
//        System.out.println("5/0 = " + 5 / 0); // java.lang.ArithmeticException: / by zero

        Thread.sleep(1000); // 编译错误
        System.out.println("程序正常结束");

    }
}
