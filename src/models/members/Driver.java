package models.members;

import enumeration.TypeOfVehicle;

/**
 * @author Negin Mousavi
 */
public class Driver extends User {
    private int vehicleId;
    private TypeOfVehicle typeOfVehicle;

    public Driver(String personalId, String firstName, String lastName, String gender, String phoneNumber, int birthYear, TypeOfVehicle typeOfVehicle, int vehicleId) {
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
        return "User{" +
                "id=" + id +
                ", personalId='" + personalId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthYear=" + birthYear +
                ", age=" + age +
                ", vehicleId=" + vehicleId +
                ", typeOfVehicle=" + typeOfVehicle +
                ", tripStatus=" + tripStatus +
                '}';
    }
}
