package by.devincubator.services.user.exceptions;

public class TestIdIsIncorrectException extends RuntimeException {
    public TestIdIsIncorrectException(Integer id) {
        super("test[id:" + id + "] doesn't exist");
    }
}
