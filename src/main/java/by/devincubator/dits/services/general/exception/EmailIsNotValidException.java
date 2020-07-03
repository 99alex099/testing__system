package by.devincubator.dits.services.general.exception;

public class EmailIsNotValidException extends RuntimeException {

    static final long serialVersionUID = -2556027832139743346L;

    public EmailIsNotValidException() {
    }

    public EmailIsNotValidException(String message) {
        super(message);
    }

    public EmailIsNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailIsNotValidException(Throwable cause) {
        super(cause);
    }

    public EmailIsNotValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}