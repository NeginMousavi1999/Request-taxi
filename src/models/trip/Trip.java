package models.trip;

import enumeration.PaymentMethod;
import enumeration.TripStatus;
import lombok.Data;

/**
 * @author Negin Mousavi
 */

@Data
public class Trip {
    private int id;
    private int driverId;
    private int passengerId;
    private String origin;
    private String destination;
    private double cost;
    private PaymentMethod paymentMethod;
    private TripStatus tripStatus;

    public Trip(int passengerId, String origin, String destination, double cost, PaymentMethod paymentMethod) {
        this.passengerId = passengerId;
        this.origin = origin;
        this.destination = destination;
        this.cost = cost;
        this.paymentMethod = paymentMethod;
        this.tripStatus = TripStatus.ON_TRIP;
    }
}
