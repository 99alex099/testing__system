package by.devincubator.services.user.exceptions;

public class AnswerIdIsIncorrectException extends RuntimeException {
    public AnswerIdIsIncorrectException(Integer id) {
        super("answer[id:" + id + "] doesn't exist");
    }
}
