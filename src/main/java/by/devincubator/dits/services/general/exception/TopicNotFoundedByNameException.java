package by.devincubator.dits.services.general.exception;

public class TopicNotFoundedByNameException extends RuntimeException {
    public TopicNotFoundedByNameException(String name) {
        super("topic '" + name + "' doesn't exist");
    }
}