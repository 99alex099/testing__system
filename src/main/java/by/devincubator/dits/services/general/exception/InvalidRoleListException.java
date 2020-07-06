package by.devincubator.dits.services.general.exception;

public class InvalidRoleListException extends RuntimeException {

    static final long serialVersionUID = 3488582879457825214L;

    public InvalidRoleListException() {
    }

    public InvalidRoleListException(String message) {
        super(message);
    }

    public InvalidRoleListException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRoleListException(Throwable cause) {
        super(cause);
    }

    public InvalidRoleListException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}