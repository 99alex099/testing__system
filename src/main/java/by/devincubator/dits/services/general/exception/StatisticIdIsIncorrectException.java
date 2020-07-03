package by.devincubator.dits.services.general.exception;

public class StatisticIdIsIncorrectException extends RuntimeException {
    public StatisticIdIsIncorrectException(Integer id) {
        super("statistic[id:" + id + "] doesn't exist");
    }
}