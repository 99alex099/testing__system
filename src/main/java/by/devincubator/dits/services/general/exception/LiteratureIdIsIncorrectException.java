package by.devincubator.dits.services.general.exception;

import lombok.Getter;

public class LiteratureIdIsIncorrectException extends RuntimeException {

    @Getter
    private int id;

    public LiteratureIdIsIncorrectException(Integer id) {
        super("literature[id:" + id + "] is incorrect");
        this.id = id;
    }
}