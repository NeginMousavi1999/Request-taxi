package accessToDB;

import models.members.Driver;

import java.sql.*;

/**
 * @author Negin Mousavi
 */
public abstract class AccessToDB {
    protected Connection connection;

    public AccessToDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taxi-agency", "root", "123456");
    }

    public int getId(String tableName, String columnName, String value) throws SQLException {
        int id = -1;
        if (connection != null) {
            String sql = String.format("SELECT id FROM %s WHERE %s = ?;", tableName, columnName);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, value);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                id = resultSet.getInt("id");
        }
        return id;
    }

    public boolean objectIsFound(String columnName, String tableName, String value) throws SQLException {
        if (connection != null) {
            String sql = String.format("SELECT %s FROM %s WHERE plaque = ?;", columnName, tableName);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, value);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        }
        return false;
    }

    public abstract void showAllObjectsInDB() throws SQLException;
}