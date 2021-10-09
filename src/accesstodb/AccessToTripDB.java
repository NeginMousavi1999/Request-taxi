package accesstodb;

import models.trip.Trip;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Negin Mousavi
 */
public class AccessToTripDB extends AccessToDB {
    public AccessToTripDB() throws ClassNotFoundException, SQLException {
    }

    @Override
    public void showAllObjectsInDB() throws SQLException {

    }

    public Trip createTrip(ResultSet resultSet) throws SQLException { //TODO chikaresh konam
        return null;
    }

    public int requestTrip(Trip trip) throws SQLException {
        if (connection != null) {
            String sql = "INSERT INTO `taxi-agency`.`trips` (`passenger_id_fk`, `origin`, `destination`, `cost`, `payment_method`) VALUES (?,?,?,?,?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, trip.getPassengerId());
            statement.setString(2, trip.getOrigin());
            statement.setString(3, trip.getDestination());
            statement.setInt(4, (int) trip.getCost());
            statement.setString(5, trip.getPaymentMethod().toString().toLowerCase());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0)
                return rowsInserted;
        }
        return 0;
    }

    public int acceptTrip(Trip trip) throws SQLException {
        if (connection != null) {
            String sql = "INSERT INTO `taxi-agency`.`trips` (`driver_id_fk` VALUES (?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, trip.getDriverId());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0)
                return rowsInserted;
        }
        return 0;
    }
}

