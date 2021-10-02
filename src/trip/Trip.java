package trip;

/**
 * @author Negin Mousavi
 */
public class Trip {
    private int driverId;
    private int passengerId;
    private String origin;
    private String destination;
    private double cost;

    public Trip(int driverId, int passengerId, String origin, String destination, double cost) {
        this.driverId = driverId;
        this.passengerId = passengerId;
        this.origin = origin;
        this.destination = destination;
        this.cost = cost;
    }
}
