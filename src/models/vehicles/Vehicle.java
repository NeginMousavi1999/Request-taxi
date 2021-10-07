package models.vehicles;

import lombok.Data;

/**
 * @author Negin Mousavi
 */
@Data
public abstract class Vehicle {
    protected int id;
    protected String name;
    protected String color;
    protected String plaque;

    public Vehicle(String name, String color, String plaque) {
        this.name = name;
        this.color = color;
        this.plaque = plaque;
    }

    @Override
    public abstract String toString();
}
