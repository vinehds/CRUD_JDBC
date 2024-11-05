package database.exception;

public class ConnectionErrorException extends RuntimeException {

    public ConnectionErrorException(String message) {
        super(message);
    }
}
