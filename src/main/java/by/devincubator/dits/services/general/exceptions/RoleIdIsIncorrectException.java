package by.devincubator.dits.services.general.exceptions;

public class RoleIdIsIncorrectException extends RuntimeException {
    public RoleIdIsIncorrectException(Integer id) {
        super("role[id:" + id + "] doesn't exist");
    }
}
