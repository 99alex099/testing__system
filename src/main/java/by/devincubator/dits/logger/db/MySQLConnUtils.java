package by.devincubator.dits.logger.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {

    public static Connection getMySQLConnection() throws SQLException,
            ClassNotFoundException {
        String hostName = "localhost";

        String dbName = "student_portal_logs";
        String userName = "alex099";
        String password = "Root1234";
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