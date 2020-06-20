package by.devincubator.dits.services.general.exceptions;

public class TopicIdIsIncorrectException extends RuntimeException {

    public TopicIdIsIncorrectException(Integer id) {
        super("topic[id:" + id + "] is incorrect");
    }
}