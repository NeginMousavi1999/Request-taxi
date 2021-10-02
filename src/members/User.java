package members;

/**
 * @author Negin Mousavi
 */
public abstract class User {
    protected int id;
    protected String personalId;
    protected String firstName;
    protected String lastName;
    protected String gender;
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
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTripStatus(boolean tripStatus) {
        this.tripStatus = tripStatus;
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

    public int getAge() {
        return age;
    }

    public boolean isTripStatus() {
        return tripStatus;
    }

    public void calculateAge(int nowYear) {
        age = nowYear - birthYear;
    }

    @Override
    public abstract String toString();
}
