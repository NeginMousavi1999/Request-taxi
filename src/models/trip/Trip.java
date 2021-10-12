package models.trip;

import enumerations.PaymentMethod;
import enumerations.TripStatus;
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

    public Trip(int id, int driverId, int passengerId, String origin, String destination, double cost, PaymentMethod paymentMethod, TripStatus tripStatus) {
        this.id = id;
        this.driverId = driverId;
        this.passengerId = passengerId;
        this.origin = origin;
        this.destination = destination;
        this.cost = cost;
        this.paymentMethod = paymentMethod;
        this.tripStatus = tripStatus;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", driverId=" + driverId +
                ", passengerId=" + passengerId +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", cost=" + cost +
                ", paymentMethod=" + paymentMethod +
                ", tripStatus=" + tripStatus +
                '}';
    }
}
