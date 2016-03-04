public class WrongOperationFormat extends Exception {
    public WrongOperationFormat() {
    }

    public WrongOperationFormat(String message) {
        super(message);
    }

    public WrongOperationFormat(String message, Throwable cause) {
        super(message, cause);
    }
}
