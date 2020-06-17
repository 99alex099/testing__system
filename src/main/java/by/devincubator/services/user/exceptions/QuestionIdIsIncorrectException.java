package by.devincubator.services.user.exceptions;

public class QuestionIdIsIncorrectException extends RuntimeException {

    public QuestionIdIsIncorrectException(Integer id) {
        super("question[id:" + id + "] is incorrect");
    }
}
