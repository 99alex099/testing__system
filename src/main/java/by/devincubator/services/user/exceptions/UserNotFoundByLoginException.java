package by.devincubator.services.user.exceptions;

public class UserNotFoundByLoginException extends RuntimeException {
    public UserNotFoundByLoginException(String login) {
        super("user with login '" + login + "' doesn't exist");
    }
}
