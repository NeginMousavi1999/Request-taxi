package dao;

import models.vehicles.Vehicle;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Negin Mousavi
 */
public class VehicleDao extends BaseDao {
    public VehicleDao() throws ClassNotFoundException, SQLException {
    }

    @Override
    public void showAllObjectsInDB() {

    }

    public void addNewVehicle(Vehicle vehicle) throws SQLException {
        if (connection != null) {
            String sql = "INSERT INTO `taxi-agency`.`vehicles` (`type`, `name`, `color`, `plaque`) VALUES (?,?,?,?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, vehicle.getTypeOfVehicle().toString().toLowerCase());
            statement.setString(2, vehicle.getName());
            statement.setString(3, vehicle.getColor());
            statement.setString(4, vehicle.getPlaque());
            statement.executeUpdate();
        }
    }
}
