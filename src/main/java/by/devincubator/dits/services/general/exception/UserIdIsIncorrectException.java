package by.devincubator.dits.services.general.exception;

public class UserIdIsIncorrectException extends RuntimeException {
    public UserIdIsIncorrectException(Integer id) {
        super("user[id:" + id + "] doesn't exist");
    }
}