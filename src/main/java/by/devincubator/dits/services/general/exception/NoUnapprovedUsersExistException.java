package by.devincubator.dits.services.general.exception;

public class NoUnapprovedUsersExistException extends RuntimeException {

    static final long serialVersionUID = 794410172596083097L;

    public NoUnapprovedUsersExistException() {
    }

    public NoUnapprovedUsersExistException(String message) {
        super(message);
    }

    public NoUnapprovedUsersExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoUnapprovedUsersExistException(Throwable cause) {
        super(cause);
    }

    public NoUnapprovedUsersExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}