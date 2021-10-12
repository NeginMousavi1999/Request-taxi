package accesstodb;

import enumerations.PaymentMethod;
import enumerations.TripStatus;
import models.trip.Trip;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Negin Mousavi
 */
public class AccessToTripDB extends AccessToDB {
    public AccessToTripDB() throws ClassNotFoundException, SQLException {
    }

    @Override
    public void showAllObjectsInDB() throws SQLException {

    }

    public List<Trip> showAllTrips() throws SQLException {
        List<Trip> trips = new ArrayList<>();
        if (connection != null) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM trips");
            while (resultSet.next()) {
                Trip trip = createTrip(resultSet);
                trips.add(trip);
            }
        }
        return trips;
    }

    public Trip createTrip(ResultSet resultSet) throws SQLException {
        Trip trip = new Trip(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3), resultSet.getString(4),
                resultSet.getString(5), resultSet.getDouble(6),
                PaymentMethod.valueOf(resultSet.getString(7).toUpperCase()),
                TripStatus.valueOf(resultSet.getString(8).toUpperCase()));
        return trip;
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

    public Trip findTripByDriverId(int driverId) throws SQLException {
        Trip trip = null;
        if (connection != null) {
            String sql = "SELECT * FROM trips where status = \"on_trip\" and driver_id_fk = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, driverId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                trip = createTrip(resultSet);
            }
        }
        return trip;
    }
}