package by.devincubator.dits.services.general.exception;

public class AnswerIdIsIncorrectException extends RuntimeException {
    public AnswerIdIsIncorrectException(Integer id) {
        super("answer[id:" + id + "] doesn't exist");
    }
}