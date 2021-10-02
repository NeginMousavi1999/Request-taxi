package members;

/**
 * @author Negin Mousavi
 */
public class Passenger extends User {

    public Passenger(int id, String personalId, String firstName, String lastName, String gender, String phoneNumber, int birthYear) {
        super(id, personalId, firstName, lastName, gender, phoneNumber, birthYear);
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
                ", tripStatus=" + tripStatus +
                '}';
    }
}

