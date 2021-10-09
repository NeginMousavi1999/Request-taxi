package models.members;

import enumeration.Gender;
import lombok.Data;

/**
 * @author Negin Mousavi
 */
@Data
public abstract class User {
    protected int id;
    protected String personalId;
    protected String firstName;
    protected String lastName;
    protected Gender gender;//TODO 1. enum
    protected String phoneNumber;
    protected int birthYear;
    protected int age;
    protected boolean tripStatus;

    public User(String personalId, String firstName, String lastName, Gender gender, String phoneNumber, int birthYear) {
        this.personalId = personalId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.birthYear = birthYear;
        tripStatus = false;
        age = calculateAge(1400);
    }

    public int calculateAge(int nowYear) {
        age = nowYear - birthYear;
        return age;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", personalId='" + personalId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender.toString().toLowerCase() +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthYear=" + birthYear +
                ", age=" + age +
                ", tripStatus=" + tripStatus + '\'';
    }
}
