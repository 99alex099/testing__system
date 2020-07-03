package by.devincubator.dits.services.general.exception;

public class RoleIdIsIncorrectException extends RuntimeException {
    public RoleIdIsIncorrectException(Integer id) {
        super("role[id:" + id + "] doesn't exist");
    }
}