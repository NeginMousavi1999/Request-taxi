import accessToDB.AccessPassengersDB;
import accessToDB.AccessToDriversDB;
import members.Driver;
import members.Passenger;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Negin Mousavi
 */
public class TaxiManager {
    AccessPassengersDB accessPassengersDB = new AccessPassengersDB();
    AccessToDriversDB accessToDriversDB = new AccessToDriversDB();
    private String fName, lName, personalId, gender, phoneNum;
    private int birthYear, carId;
    Scanner scanner = new Scanner(System.in);


    public TaxiManager() throws SQLException, ClassNotFoundException {
    }

    public void createDriver(int caseNum) throws SQLException {
        int count = 0;
        int addedSuc = 0;
        if (caseNum == 3)
            count = 1;
        else if (caseNum == 1) {
            System.out.print("Enter count of drivers you wanna add: ");
            count = scanner.nextInt();
        }
        Driver[] drivers = new Driver[count];

        for (int i = 0; i < count; i++) {
            System.out.println("** information for new driver **");
            commonInformationInputs();
            System.out.print("car id: ");
            int carId = scanner.nextInt();
            //TODO create car....
            drivers[i] = new Driver(i + 1, personalId, fName, lName, gender, phoneNum, birthYear, carId);
            addedSuc += accessToDriversDB.addNewDriver(drivers[i]);
            drivers[i].setId(accessToDriversDB.getId("drivers", personalId));
            System.out.println("id: " + drivers[i].getId());
        }
        if (addedSuc == count)
            System.out.println(count + " new driver(s) were added successfully");
        else
            System.out.println("some thing were wrong...");
    }

    public void createPassenger(int caseNum) throws SQLException {
        int count = 0;
        int addedSuc = 0;
        if (caseNum == 4) {
            count = 1;
        } else if (caseNum == 2) {
            System.out.print("Enter count of passengers you wanna add: ");
            count = scanner.nextInt();
        }
        Passenger[] passengers = new Passenger[count];

        for (int i = 0; i < count; i++) {
            System.out.println("** information for new passenger **");
            commonInformationInputs();
            passengers[i] = new Passenger(0, personalId, fName, lName, gender, phoneNum, birthYear);
            addedSuc += accessPassengersDB.addNewPassenger(passengers[i]);
            passengers[i].setId(accessPassengersDB.getId("passengers", personalId));
            System.out.println("id: " + passengers[i].getId());
        }
        if (addedSuc == count)
            System.out.println(count + " new passenger(s) were added successfully");
        else
            System.out.println("some thing were wrong...");
    }

    public void commonInformationInputs() {
        scanner.nextLine();
        System.out.print("first name: ");
        fName = scanner.nextLine();

        System.out.print("last name: ");
        lName = scanner.nextLine();

        System.out.print("personal id: ");
        personalId = scanner.nextLine();

        System.out.print("gender(f/m): ");
        gender = scanner.nextLine();

        System.out.print("phone number: ");
        phoneNum = scanner.nextLine();

        System.out.print("birth year: ");
        birthYear = scanner.nextInt();
    }
}
