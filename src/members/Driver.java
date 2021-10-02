package members;

/**
 * @author Negin Mousavi
 */
public class Driver extends User{
    private int carId;
    public Driver(int id, String personalId, String firstName, String lastName, String gender, String phoneNumber, int birthYear, int carId) {
        super(id, personalId, firstName, lastName, gender, phoneNumber, birthYear);
        this.carId = carId; //TODO add this car to cars --> nabayad vojud dashte bashe
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
                ", carId=" + carId +
                ", tripStatus=" + tripStatus +
                '}';
    }
}
