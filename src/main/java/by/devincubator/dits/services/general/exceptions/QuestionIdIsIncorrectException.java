package by.devincubator.dits.services.general.exceptions;

public class QuestionIdIsIncorrectException extends RuntimeException {

    public QuestionIdIsIncorrectException(Integer id) {
        super("question[id:" + id + "] is incorrect");
    }
}
