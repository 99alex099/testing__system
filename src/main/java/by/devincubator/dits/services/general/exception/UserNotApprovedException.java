package by.devincubator.dits.services.general.exception;

public class UserNotApprovedException extends RuntimeException {

    static final long serialVersionUID = -6979452887461653623L;

    public UserNotApprovedException() {
    }

    public UserNotApprovedException(String message) {
        super(message);
    }

    public UserNotApprovedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotApprovedException(Throwable cause) {
        super(cause);
    }

    public UserNotApprovedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
