package by.devincubator.dits.services.general.exceptions;

public class StatisticUserNameIsIncorrectException extends RuntimeException {
    private String username;

    public StatisticUserNameIsIncorrectException(String username) {
        super("username " + username + " is not founded in db");
        this.username = username;

    }
}
