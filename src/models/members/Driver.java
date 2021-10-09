package models.members;

import enumeration.Gender;
import enumeration.TypeOfVehicle;

/**
 * @author Negin Mousavi
 */
public class Driver extends User {
    private int vehicleId;
    private TypeOfVehicle typeOfVehicle;

    public Driver(String personalId, String firstName, String lastName, Gender gender, String phoneNumber, int birthYear, TypeOfVehicle typeOfVehicle, int vehicleId) {
        super(personalId, firstName, lastName, gender, phoneNumber, birthYear);
        this.vehicleId = vehicleId;
        this.typeOfVehicle = typeOfVehicle;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public TypeOfVehicle getTypeOfVehicle() {
        return typeOfVehicle;
    }

    @Override
    public String toString() {
        String s = "Drivers{" +
                super.toString() + '\'' +
                ", vehicleId=" + vehicleId +
                ", typeOfVehicle=" + typeOfVehicle.toString().toLowerCase() +
                '}';
        return s;
    }
}
