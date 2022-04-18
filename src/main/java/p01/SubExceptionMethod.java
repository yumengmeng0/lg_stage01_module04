package p01;

import java.io.IOException;

/**
 * @author: ymm
 * @date: 2022/4/18
 * @version: 1.0.0
 * @description:
 */
public class SubExceptionMethod extends ExceptionMethod {

    /**
     * 子类重写的方法可以抛出父类中方法一样的异常、可以抛出更小的异常，可以不抛出异常
     * 不能抛出平级不一样的异常，不能抛出更大的异常
     * @throws IOException
     */
    @Override
    public void show() throws IOException {
        super.show();
    }
}
