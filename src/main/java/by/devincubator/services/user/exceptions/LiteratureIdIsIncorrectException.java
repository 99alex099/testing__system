package by.devincubator.services.user.exceptions;

public class LiteratureIdIsIncorrectException extends RuntimeException {

    public LiteratureIdIsIncorrectException(Integer id) {
        super("literature[id:" + id + "] is incorrect");
    }
}
