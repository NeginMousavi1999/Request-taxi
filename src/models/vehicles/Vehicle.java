package models.vehicles;

/**
 * @author Negin Mousavi
 */
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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getPlaque() {
        return plaque;
    }

    @Override
    public abstract String toString();
}
