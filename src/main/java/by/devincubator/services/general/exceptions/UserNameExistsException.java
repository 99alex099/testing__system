package by.devincubator.services.general.exceptions;

import lombok.Getter;

public class UserNameExistsException extends RuntimeException {

    @Getter
    private String username;

    public UserNameExistsException(String username) {
        super("user '" + username + "' exists");
        this.username = username;
    }
}
