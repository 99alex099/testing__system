package by.devincubator.dits.logger.db.repository.mysql;

import by.devincubator.dits.logger.db.repository.Crud;
import by.devincubator.dits.logger.db.repository.LogRepository;
import by.devincubator.dits.logger.services.LogModel;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class LogRepositoryMySQL extends CrudMySQL<LogModel> implements LogRepository {
    protected LogRepositoryMySQL() {
        super("history");
    }

    @Override
    protected String getInsertFields() {
        return "historyId, user, action";
    }

    @Override
    protected String getValueToInsert(LogModel entity) {
        return String.format(
                "%s, '%s', '%s'", entity.getId(), entity.getUser(), entity.getAction()
        );
    }

    @Override
    protected LogModel getEntity(ResultSet rs) throws SQLException {
        int logId = rs.getInt(1);
        String user = rs.getString(2);
        String action = rs.getString(3);
        Timestamp date = rs.getTimestamp(4);
        return new LogModel(logId, user, action, date);
    }

    @Override
    public List<LogModel> findByUser(String user) throws SQLException {
        return loadList(String.format(
                "SELECT * FROM history WHERE user = '%s'", user
        ));
    }
}
