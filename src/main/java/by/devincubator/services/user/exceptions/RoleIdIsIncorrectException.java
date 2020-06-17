package by.devincubator.services.user.exceptions;

public class RoleIdIsIncorrectException extends RuntimeException {
    public RoleIdIsIncorrectException(Integer id) {
        super("role[id:" + id + "] doesn't exist");
    }
}
