package by.devincubator.dits.logger.services;

import by.devincubator.dits.entities.User;

import java.sql.SQLException;
import java.util.List;

public interface LogService {
    void write(String msg, User user) throws SQLException;
    void write(String msg, String username) throws SQLException;
    List<LogModel> findByUser(User user) throws SQLException;
    List<LogModel> findByUser(String username) throws SQLException;
}
