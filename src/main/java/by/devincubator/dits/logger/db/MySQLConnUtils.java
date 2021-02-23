package by.devincubator.dits.logger.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {

    public static Connection getMySQLConnection() throws SQLException,
            ClassNotFoundException {
        String hostName = "remotemysql.com";

        String dbName = "n2TVd9qz0P";
        String userName = "n2TVd9qz0P";
        String password = "qjLnVIuQ27";
        String port = "3306";

        return getMySQLConnection(hostName, dbName, userName, password, port);
    }

    private static Connection getMySQLConnection(String hostName, String dbName,
                                                 String userName, String password, String port) throws SQLException,
            ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        String connectionURL = "jdbc:mysql://" + hostName + ":" + port + "/" + dbName
                + "?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";

        return DriverManager.getConnection(connectionURL, userName,
                password);
    }
}