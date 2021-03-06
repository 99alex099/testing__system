package by.devincubator.dits.services.general.exception;

public class TestIdIsIncorrectException extends RuntimeException {
    public TestIdIsIncorrectException(Integer id) {
        super("test[id:" + id + "] doesn't exist");
    }
}