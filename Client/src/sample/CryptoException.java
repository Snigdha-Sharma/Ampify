package sample;

/**
 * To throw customized exception
 */
public class CryptoException extends Exception {

    /**
     * @param message show customized message
     * @param throwable for throwing new exception
     */
    public CryptoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}