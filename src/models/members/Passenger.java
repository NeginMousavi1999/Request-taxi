package models.members;

import enumeration.Gender;

/**
 * @author Negin Mousavi
 */
public class Passenger extends User {
    private double accountBalance;

    public Passenger(String personalId, String firstName, String lastName, Gender gender, String phoneNumber, int birthYear, double accountBalance) {
        super(personalId, firstName, lastName, gender, phoneNumber, birthYear);
        this.accountBalance = accountBalance;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public double increaseAccountBalance(double amount) {
        return accountBalance += amount;
    }

    public void requestTrip() {

    }

    @Override
    public String toString() {
        String s = "Passenger{" +
                super.toString() + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
        return s;
    }
}