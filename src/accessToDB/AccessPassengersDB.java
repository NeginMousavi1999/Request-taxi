package accessToDB;

import members.Passenger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Negin Mousavi
 */
public class AccessPassengersDB extends AccessToDB{
    public AccessPassengersDB() throws ClassNotFoundException, SQLException {
    }

    public int addNewPassenger(Passenger passenger) throws SQLException {
        if (connection != null) {
            String sql = "INSERT INTO `taxi-agency`.`passengers` (`id`, `first_name`, `last_name`, `birth_year`, `gender`, `phone_number`," +
                    " `personal_id`, `status`) VALUES (?,?,?,?,?,?,?,?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, passenger.getId());
            statement.setString(2, passenger.getFirstName());
            statement.setString(3, passenger.getLastName());
            statement.setInt(4, passenger.getBirthYear());
            statement.setString(5, passenger.getGender());
            statement.setString(6, passenger.getPhoneNumber());
            statement.setString(7, passenger.getPersonalId());
            statement.setBoolean(8, passenger.isTripStatus());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0)
                return rowsInserted;
        }
        return 0;
    }
}
