package enumeration;

/**
 * @author Negin Mousavi
 */
public enum TypeOfVehicle {
    CAR("car");

    String abbr;

    TypeOfVehicle(String abbr) {
        this.abbr = abbr;
    }

    public String getAbbr() {
        return abbr;
    }
}
