package by.devincubator.services.user.exceptions;

public class UserIdIsIncorrectException extends RuntimeException {
    public UserIdIsIncorrectException(Integer id) {
        super("user[id:" + id + "] doesn't exist");
    }
}
