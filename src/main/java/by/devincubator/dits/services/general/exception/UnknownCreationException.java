package by.devincubator.dits.services.general.exception;

/**
 * {@code UnknownCreationException} is an unchecked exception,
 * can be thrown when something wrong happened during
 * {@Question}, {@Test} or {@Topic} creation.
 *
 * @Author Nikita Muzyka
 */

public class UnknownCreationException extends RuntimeException {

    static final long serialVersionUID = -2443950159561908509L;

    public UnknownCreationException() {
        super();
    }

    public UnknownCreationException(String message) {
        super(message);
    }

    public UnknownCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownCreationException(Throwable cause) {
        super(cause);
    }

    protected UnknownCreationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}