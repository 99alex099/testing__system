package by.devincubator.services.general.exceptions;

public class AnswerIdIsIncorrectException extends RuntimeException {
    public AnswerIdIsIncorrectException(Integer id) {
        super("answer[id:" + id + "] doesn't exist");
    }
}
