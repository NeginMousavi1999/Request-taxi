package accesstodb;

import models.vehicles.Vehicle;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Negin Mousavi
 */
public class AccessToVehicleDB extends AccessToDB {
    public AccessToVehicleDB() throws ClassNotFoundException, SQLException {
    }

    @Override
    public void showAllObjectsInDB() throws SQLException {

    }

    public int addNewDriver(Vehicle vehicle) throws SQLException {
        if (connection != null) {
            String sql = "INSERT INTO `taxi-agency`.`vehicles` (`type`, `name`, `color`, `plaque`) VALUES (?,?,?,?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "car");
            statement.setString(2, vehicle.getName());
            statement.setString(3, vehicle.getColor());
            statement.setString(4, vehicle.getPlaque());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0)
                return rowsInserted;
        }
        return 0;
    }
}
