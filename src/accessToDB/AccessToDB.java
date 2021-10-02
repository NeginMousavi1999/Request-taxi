package accessToDB;

import java.sql.*;

/**
 * @author Negin Mousavi
 */
public class AccessToDB {
    protected Connection connection;

    public AccessToDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taxi-agency", "root", "123456");
    }

    public int getId(String tableName, String personalId) throws SQLException {
        int id = -1;
        if (connection != null) {
            String sql = String.format("SELECT id FROM %s WHERE personal_id = ?;", tableName);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, personalId);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                id = resultSet.getInt("id");
        }
        return id;
    }
}
