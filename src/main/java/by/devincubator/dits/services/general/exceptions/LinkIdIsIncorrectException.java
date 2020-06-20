package by.devincubator.dits.services.general.exceptions;

public class LinkIdIsIncorrectException extends RuntimeException {
    public LinkIdIsIncorrectException(Integer id) {
        super("link[id:" + id + "] doesn't exist");
    }
}