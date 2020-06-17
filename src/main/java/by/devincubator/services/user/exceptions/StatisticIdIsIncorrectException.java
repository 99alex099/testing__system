package by.devincubator.services.user.exceptions;

public class StatisticIdIsIncorrectException extends RuntimeException {
    public StatisticIdIsIncorrectException(Integer id) {
        super("statistic[id:" + id + "] doesn't exist");
    }
}
