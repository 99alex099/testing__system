package by.devincubator.dits.services.general.exception;

public class QuestionIdIsIncorrectException extends RuntimeException {

    public QuestionIdIsIncorrectException(Integer id) {
        super("question[id:" + id + "] is incorrect");
    }
}