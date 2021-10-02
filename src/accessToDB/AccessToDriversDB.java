package accessToDB;

import members.Driver;
import members.Passenger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Negin Mousavi
 */
public class AccessToDriversDB extends AccessToDB{
    public AccessToDriversDB() throws ClassNotFoundException, SQLException {
    }

    public int addNewDriver(Driver driver) throws SQLException {
        if (connection != null) {
            String sql = "INSERT INTO `taxi-agency`.`drivers` (`first_name`, `last_name`, `birth_year`, `gender`, `phone_number`," +
                    " `personal_id`, `status`, `car_id_fk`) VALUES (?,?,?,?,?,?,?,?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, driver.getFirstName());
            statement.setString(2, driver.getLastName());
            statement.setInt(3, driver.getBirthYear());
            statement.setString(4, driver.getGender());
            statement.setString(5, driver.getPhoneNumber());
            statement.setString(6, driver.getPersonalId());
            statement.setBoolean(7, driver.isTripStatus());
            statement.setInt(8, driver.getCarId());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0)
                return rowsInserted;
        }
        return 0;
    }
}
