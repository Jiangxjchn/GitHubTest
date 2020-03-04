package Aspect;

public class DishNotEnoughException extends Exception {
        public DishNotEnoughException() {
        }
        public DishNotEnoughException(String message) {
            super(message);
        }
        public DishNotEnoughException(String message, Throwable cause) {
            super(message, cause);
        }
        public DishNotEnoughException(Throwable cause) {
            super(cause);
        }
}
