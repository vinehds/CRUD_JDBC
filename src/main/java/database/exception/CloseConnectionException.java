package database.exception;

public class CloseConnectionException extends RuntimeException {

    public CloseConnectionException(String message) {
        super(message);
    }
}
