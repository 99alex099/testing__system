package by.devincubator.services.user.exceptions;

public class TopicIdIsIncorrectException extends RuntimeException {

    public TopicIdIsIncorrectException(Integer id) {
        super("topic[id:" + id + "] is incorrect");
    }
}
