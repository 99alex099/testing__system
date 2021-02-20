package by.devincubator.dits.logger.db.repository.mysql;

import by.devincubator.dits.logger.db.ConnectionUtils;
import by.devincubator.dits.logger.db.repository.Crud;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public abstract class CrudMySQL<T> implements Crud<T> {
    private static final Connection connection = ConnectionUtils.getMyConnection();
    private String tableName;

    protected CrudMySQL(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public void save(T entity) throws SQLException {
        Statement statement = connection.createStatement();

        String sql = String.format("Insert into %s (%s) values (%s) ",
                tableName, getInsertFields(), getValueToInsert(entity));

        System.out.println(sql);

        int rowCount = statement.executeUpdate(sql);
    }

    protected abstract String getInsertFields();
    protected abstract String getValueToInsert(T entity);

    protected List<T> loadList(String sqlQuery) throws SQLException {
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery(sqlQuery);

        List<T> entityList = new LinkedList<>();

        while (rs.next()) {
            entityList.add(getEntity(rs));
            /*int empId = rs.getInt(1);
            String empNo = rs.getString(2);
            String empName = rs.getString("Emp_Name");*/
        }

        return entityList;
    }

    protected abstract T getEntity(ResultSet rs) throws SQLException;
}
