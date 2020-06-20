package by.devincubator.dits.services.general.exceptions;

public class UserNotFoundByFirstNameAndLastNameException extends RuntimeException {
    public UserNotFoundByFirstNameAndLastNameException(
            String firstName, String lastName) {

        super("user with first name '" + firstName
                + " and " + lastName
                + "' doesn't exist");
    }
}