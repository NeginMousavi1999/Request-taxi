package models.members;

/**
 * @author Negin Mousavi
 */
public class Passenger extends User {
    private double accountBalance;

    public Passenger(String personalId, String firstName, String lastName, String gender, String phoneNumber, int birthYear, double accountBalance) {
        super(personalId, firstName, lastName, gender, phoneNumber, birthYear);
        this.accountBalance = accountBalance;
    }

    public double getAccountBalance() {
        return accountBalance;
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
                ", accountBalance=" + accountBalance +
                '}';
    }
}

