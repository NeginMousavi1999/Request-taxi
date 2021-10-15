package dao;

import models.members.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Negin Mousavi
 */
public class UserDao extends BaseDao{

    public UserDao() throws ClassNotFoundException, SQLException {
    }

    @Override
    public void showAllObjectsInDB() throws SQLException {

    }

    public User returnUserIfExists(String tableName, String columnName, String value) throws SQLException {
        if (connection != null) {
            String sql = String.format("SELECT * FROM %s WHERE %s = ?;", tableName, columnName);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, value);
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

    public User returnUserById(String tableName, int id) throws SQLException {
        if (connection != null) {
            String sql = String.format("SELECT * FROM %s WHERE id = ?;", tableName);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return createUser(resultSet);
            }
        }
        return null;
    }
}
