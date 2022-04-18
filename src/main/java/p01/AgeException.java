package p01;

/**
 * @author: ymm
 * @date: 2022/4/18
 * @version: 1.0.0
 * @description:
 */
public class AgeException extends Exception{

    static final long serialVersionUID = -3387516993124229948L;

    public AgeException() {
    }

    public AgeException(String message) {
        super(message);
    }
}
