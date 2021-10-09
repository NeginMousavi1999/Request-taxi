package models.trip;

import enumeration.PaymentMethod;
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
    private boolean status;

    public Trip(int passengerId, String origin, String destination, double cost, PaymentMethod paymentMethod) {
        this.passengerId = passengerId;
        this.origin = origin;
        this.destination = destination;
        this.cost = cost;
        this.paymentMethod = paymentMethod;
    }
}
