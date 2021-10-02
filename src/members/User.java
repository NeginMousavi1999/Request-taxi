package members;

/**
 * @author Negin Mousavi
 */
public class User {
    protected int id;
    protected String personalId;
    protected String firstName;
    protected String lastName;
    protected String gender;
    protected String phoneNumber;
    protected int birthYear;
    protected int age;
    protected boolean tripStatus;

    public User(int id, String personalId, String firstName, String lastName, String gender, String phoneNumber, int birthYear) {
        this.id = id;
        this.personalId = personalId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.birthYear = birthYear;
        tripStatus = false;
    }

    public void calculateAge(int nowYear) {
        age = nowYear - birthYear;
    }
}
