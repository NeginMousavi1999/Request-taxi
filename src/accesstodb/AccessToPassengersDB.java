package accesstodb;

import models.members.Passenger;
import models.members.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Negin Mousavi
 */
public class AccessToPassengersDB extends AccessToDB {
    public AccessToPassengersDB() throws ClassNotFoundException, SQLException {
    }

    public int addNewPassenger(Passenger passenger) throws SQLException {
        if (connection != null) {
            String sql = "INSERT INTO `taxi-agency`.`passengers` (`first_name`, `last_name`, `birth_year`, `gender`, `phone_number`," +
                    " `personal_id`, `status`, `account_balance`) VALUES (?,?,?,?,?,?,?,?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, passenger.getFirstName());
            statement.setString(2, passenger.getLastName());
            statement.setInt(3, passenger.getBirthYear());
            statement.setString(4, passenger.getGender());
            statement.setString(5, passenger.getPhoneNumber());
            statement.setString(6, passenger.getPersonalId());
            statement.setBoolean(7, passenger.isTripStatus());
            statement.setDouble(8, passenger.getAccountBalance());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0)
                return rowsInserted;
        }
        return 0;
    }

    @Override
    public void showAllObjectsInDB() throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM passengers");
            while (resultSet.next()) {
                User passenger = createUser(resultSet);
                System.out.println(passenger.toString());
            }
        }
    }

    @Override
    public User createUser(ResultSet resultSet) throws SQLException {
        Passenger passenger = new Passenger(resultSet.getString(7), resultSet.getString(2),
                resultSet.getString(3), resultSet.getString(5), resultSet.getString(6),
                resultSet.getInt(4), resultSet.getDouble(9));
        passenger.setId(resultSet.getInt(1));
        return passenger;
    }

    public void updateAccountBalance(double value, int id) throws SQLException {
        if (connection != null) {
            String sql = String.format("UPDATE passengers SET account_balance='%s' WHERE id=%o", value, id);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate(sql);
        }
    }
}
