package by.devincubator.dits.logger.services;

import by.devincubator.dits.entities.User;
import by.devincubator.dits.logger.db.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogRepository logRepository;


    @Override
    public void write(String msg, User user) throws SQLException {
        write(msg, user.getUsername());
    }

    @Override
    public void write(String msg, String username) throws SQLException {
        logRepository.save(
                new LogModel(username, msg)
        );
    }

    @Override
    public List<LogModel> findByUser(User user) throws SQLException {
        return logRepository.findByUser(user.getUsername());
    }

    @Override
    public List<LogModel> findByUser(String username) throws SQLException {
        return logRepository.findByUser(username);
    }
}
