package by.devincubator.services.general.exceptions;

public class TestIdIsIncorrectException extends RuntimeException {
    public TestIdIsIncorrectException(Integer id) {
        super("test[id:" + id + "] doesn't exist");
    }
}
