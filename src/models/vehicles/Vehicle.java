package models.vehicles;

import enumeration.TypeOfVehicle;
import lombok.Data;

/**
 * @author Negin Mousavi
 */
@Data
public class Vehicle {
    protected int id;
    protected String name;
    protected String color;
    protected String plaque;
    protected TypeOfVehicle typeOfVehicle;

    public Vehicle(String name, String color, String plaque, TypeOfVehicle typeOfVehicle) {
        this.name = name;
        this.color = color;
        this.plaque = plaque;
        this.typeOfVehicle = typeOfVehicle;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", plaque='" + plaque + '\'' +
                '}';
    }
}
