package accesstodb;

import enumeration.TripStatus;
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

    public Trip createTrip(ResultSet resultSet) throws SQLException {
        return null;
    }

    public void addNewTrip(Trip trip) throws SQLException {
        if (connection != null) {
            String sql = "INSERT INTO `taxi-agency`.`trips` (`passenger_id_fk`, `origin`, `destination`, `cost`, `payment_method`, `driver_id_fk`," +
                    " `status`) VALUES (?,?,?,?,?,?,?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, trip.getPassengerId());
            statement.setString(2, trip.getOrigin());
            statement.setString(3, trip.getDestination());
            statement.setInt(4, (int) trip.getCost());
            statement.setString(5, trip.getPaymentMethod().toString().toLowerCase());
            statement.setInt(6, trip.getDriverId());
            statement.setString(7, "on_trip");
            statement.executeUpdate();
        }
    }

    public void updateStatus(Trip trip, TripStatus tripStatus) throws SQLException {
        if (connection != null) {
            String sql = "UPDATE trips SET status = ? WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, tripStatus.toString().toLowerCase());
            statement.setInt(2, trip.getId());
            statement.executeUpdate();
        }
    }
}