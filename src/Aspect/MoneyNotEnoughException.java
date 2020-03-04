package Aspect;

public class MoneyNotEnoughException extends Exception {
    public MoneyNotEnoughException() {
    }

    public MoneyNotEnoughException(String message) {
        super(message);
    }
    public MoneyNotEnoughException(String message, Throwable cause) {
        super(message, cause);
    }
    public MoneyNotEnoughException(Throwable cause) {
        super(cause);
    }
}
