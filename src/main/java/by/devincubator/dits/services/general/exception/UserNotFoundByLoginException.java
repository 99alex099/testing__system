package by.devincubator.dits.services.general.exception;

public class UserNotFoundByLoginException extends RuntimeException {

    static final long serialVersionUID = -1426617003228771819L;

    public UserNotFoundByLoginException() {
    }

    public UserNotFoundByLoginException(String message) {
        super(message);
    }

    public UserNotFoundByLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundByLoginException(Throwable cause) {
        super(cause);
    }

    public UserNotFoundByLoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}