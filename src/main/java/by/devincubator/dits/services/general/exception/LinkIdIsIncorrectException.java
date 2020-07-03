package by.devincubator.dits.services.general.exception;

public class LinkIdIsIncorrectException extends RuntimeException {
    public LinkIdIsIncorrectException(Integer id) {
        super("link[id:" + id + "] doesn't exist");
    }
}