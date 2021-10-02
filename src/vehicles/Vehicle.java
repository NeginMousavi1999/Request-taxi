package vehicles;

/**
 * @author Negin Mousavi
 */
public abstract class Vehicle {
    protected int id;
    protected String name;
    protected String color;
    protected String plaque;

    public Vehicle(int id, String name, String color, String plaque) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.plaque = plaque;
    }
}
