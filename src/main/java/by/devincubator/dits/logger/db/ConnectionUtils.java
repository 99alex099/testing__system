package by.devincubator.dits.logger.db;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {

    public static Connection getMyConnection() {
        try {
            return MySQLConnUtils.getMySQLConnection();
        } catch (Exception e) {
            return null;
        }
    }

}