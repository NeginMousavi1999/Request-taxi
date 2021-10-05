package models.members;

/**
 * @author Negin Mousavi
 */
public abstract class User {
    protected int id;
    protected String personalId;
    protected String firstName;
    protected String lastName;
    protected String gender;//enum
    protected String phoneNumber;
    protected int birthYear;
    protected int age;
    protected boolean tripStatus;

    public User(String personalId, String firstName, String lastName, String gender, String phoneNumber, int birthYear) {
        this.personalId = personalId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.birthYear = birthYear;
        tripStatus = false;
        age = calculateAge(1400);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getPersonalId() {
        return personalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public boolean isTripStatus() {
        return tripStatus;
    }

    public int calculateAge(int nowYear) {
        age = nowYear - birthYear;
        return age;
    }

    @Override
    public abstract String toString();
}
