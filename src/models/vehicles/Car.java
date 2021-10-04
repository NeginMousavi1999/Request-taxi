package models.vehicles;

/**
 * @author Negin Mousavi
 */
public class Car extends Vehicle {
    public Car(String name, String color, String plaque) {
        super(name, color, plaque);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", plaque='" + plaque + '\'' +
                '}';
    }
}
