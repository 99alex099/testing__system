package by.devincubator.dits.logger.db.repository;

import by.devincubator.dits.logger.services.LogModel;

import java.sql.SQLException;
import java.util.List;

public interface LogRepository extends Crud<LogModel> {
    List<LogModel> findByUser(String user) throws SQLException;
}
