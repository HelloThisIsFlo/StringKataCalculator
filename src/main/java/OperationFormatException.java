public class OperationFormatException extends Exception {
    public OperationFormatException() {
    }

    public OperationFormatException(String message) {
        super(message);
    }

    public OperationFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public OperationFormatException(Throwable cause) {
        super(cause);
    }

    public OperationFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
