package by.devincubator.dits.services.general.exceptions;

public class UserNotFoundByLoginException extends RuntimeException {
    public UserNotFoundByLoginException(String login) {
        super("user with login '" + login + "' doesn't exist");
    }
}
