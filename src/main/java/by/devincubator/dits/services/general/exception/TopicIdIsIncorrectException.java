package by.devincubator.dits.services.general.exception;

public class TopicIdIsIncorrectException extends RuntimeException {

    public TopicIdIsIncorrectException(Integer id) {
        super("topic[id:" + id + "] is incorrect");
    }
}