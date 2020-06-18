package by.devincubator.dits.services.general.exceptions;

public class LiteratureIdIsIncorrectException extends RuntimeException {

    public LiteratureIdIsIncorrectException(Integer id) {
        super("literature[id:" + id + "] is incorrect");
    }
}
