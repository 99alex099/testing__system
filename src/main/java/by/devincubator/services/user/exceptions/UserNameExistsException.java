package by.devincubator.services.user.exceptions;

import lombok.Getter;

public class UserNameExistsException extends RuntimeException {

    @Getter
    private String username;

    public UserNameExistsException(String username) {
        super("user '" + username + "' exists");
        this.username = username;
    }
}
