package models.members;

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
    protected String gender;//TODO 1. enum
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

    public int calculateAge(int nowYear) {
        age = nowYear - birthYear;
        return age;
    }

    @Override
    public abstract String toString();
}
