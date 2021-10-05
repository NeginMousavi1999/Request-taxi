package accessToDB;

import models.members.User;

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

    public boolean isObjectFound(String tableName, String columnName, String value) throws SQLException {
        if (connection != null) {
            String sql = String.format("SELECT * FROM %s WHERE %s = ?;", tableName, columnName);
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

    public User returnUserIfExists(String tableName, String personalId) throws SQLException {
        if (connection != null) {
            String sql = String.format("SELECT * FROM %s WHERE personal_id = ?;", tableName);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, personalId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return createUser(resultSet);
            }
        }
        return null;
    }

    public User createUser(ResultSet resultSet) throws SQLException {
        return null;
    }
}