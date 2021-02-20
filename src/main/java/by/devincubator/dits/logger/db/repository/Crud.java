package by.devincubator.dits.logger.db.repository;

import java.sql.SQLException;

public interface Crud<T> {
    void save(T entity) throws SQLException;
}
