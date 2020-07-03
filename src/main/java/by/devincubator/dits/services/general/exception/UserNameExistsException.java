package by.devincubator.dits.services.general.exception;

import lombok.Getter;

public class UserNameExistsException extends RuntimeException {

    @Getter
    private String username;

    public UserNameExistsException(String username) {
        super("user '" + username + "' exists");
        this.username = username;
    }
}