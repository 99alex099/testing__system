package by.devincubator.services.general.exceptions;

public class RoleNameNotFoundException extends RuntimeException {

    static final long serialVersionUID = -4197125128251740310L;

    public RoleNameNotFoundException() {
    }

    public RoleNameNotFoundException(String message) {
        super(message);
    }

    public RoleNameNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoleNameNotFoundException(Throwable cause) {
        super(cause);
    }

    public RoleNameNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}