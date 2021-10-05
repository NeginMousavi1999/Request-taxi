import accessToDB.AccessToPassengersDB;
import accessToDB.AccessToDriversDB;
import accessToDB.AccessToVehicleDB;
import enumeration.TypeOfVehicle;
import models.members.Driver;
import models.members.Passenger;
import models.members.User;
import models.vehicles.Car;
import models.vehicles.Vehicle;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Negin Mousavi
 */
public class TaxiManager {
    Scanner scanner = new Scanner(System.in);
    AccessToPassengersDB accessToPassengersDB = new AccessToPassengersDB();
    AccessToDriversDB accessToDriversDB = new AccessToDriversDB();
    AccessToVehicleDB accessToVehicleDB = new AccessToVehicleDB();
    private String fName, lName, personalId, gender, phoneNum;
    private int birthYear, vehicleId;

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
            getCommonInformationInputs();
            if (accessToDriversDB.objectIsFound("drivers", "personal_id", personalId)) {
                System.out.println("you can't register, there is a driver with this personal id!");
                return;
            }
            scanner.nextLine();
            System.out.print("vehicle plaque: ");
            String vehiclePlaque = scanner.nextLine();
            if (isCarExists(vehiclePlaque)) {
                System.out.println("you can choose this vehicle plaque because it is exits already...");
                return;
            } else {
                System.out.print("vehicle name: ");
                String name = scanner.nextLine();
                System.out.print("vehicle color: ");
                String color = scanner.nextLine();
                vehicleId = createVehicleAndReturnId(name, color, vehiclePlaque);
            }
            drivers[i] = new Driver(personalId, fName, lName, gender, phoneNum, birthYear, TypeOfVehicle.CAR, vehicleId);
            addedSuc += accessToDriversDB.addNewDriver(drivers[i]);
            drivers[i].setId(accessToDriversDB.getId("drivers", "personal_id", personalId));
            System.out.println("id: " + drivers[i].getId());
        }
        if (addedSuc == count)
            System.out.println(count + " new driver(s) were added successfully");
        else
            System.out.println("some thing were wrong...");
    }

    private int createVehicleAndReturnId(String name, String color, String plaque) throws SQLException {
        Vehicle vehicle = new Car(name, color, plaque);
        accessToVehicleDB.addNewDriver(vehicle);
        vehicle.setId(accessToVehicleDB.getId("vehicles", "plaque", plaque));
        return vehicle.getId();
    }

    private boolean isCarExists(String vehiclePlaque) throws SQLException {
        return accessToDriversDB.objectIsFound("vehicles", "plaque", vehiclePlaque);
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
            getCommonInformationInputs();
            if (accessToPassengersDB.objectIsFound("passengers", "personal_id", personalId)) {
                System.out.println("you can't register, there is a driver with this personal id!");
                return;
            }
            scanner.nextLine();
            System.out.print("account balance: ");
            double accountBalance = scanner.nextDouble();
            passengers[i] = new Passenger(personalId, fName, lName, gender, phoneNum, birthYear, accountBalance);
            addedSuc += accessToPassengersDB.addNewPassenger(passengers[i]);
            passengers[i].setId(accessToPassengersDB.getId("passengers", "personal_id", personalId));
            System.out.println("id: " + passengers[i].getId());
        }
        if (addedSuc == count)
            System.out.println(count + " new passenger(s) were added successfully");
        else
            System.out.println("some thing were wrong...");
    }

    public void getCommonInformationInputs() {
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

    public void showAllPassengers() throws SQLException {
        accessToPassengersDB.showAllObjectsInDB();
    }

    public void showAllDrivers() throws SQLException {
        accessToDriversDB.showAllObjectsInDB();
    }

    public void signupOrLogin(int caseNum) throws SQLException {
        System.out.print("enter your Personal Id: ");
        String inputPersonalId = scanner.nextLine();
        if (caseNum == 3) {
            User driver = accessToDriversDB.ReturnUserIfExists("drivers", inputPersonalId);
            if (driver == null)
                registerOrExit("d");
            else
                System.out.println("you are authenticate");

        } else if (caseNum == 4) {
            User passenger = accessToPassengersDB.ReturnUserIfExists("passengers", inputPersonalId);
            if (passenger == null)
                registerOrExit("p");
            else {
                showPassengerLoginMenu((Passenger) passenger);
            }
        }
        scanner.nextLine();
    }

    public void showPassengerLoginMenu(Passenger passenger) throws SQLException {
        System.out.print("you are authenticate\n1)Increase account balance\n2)Exit\nwhat do you wanna do? : ");
        int answer = scanner.nextInt();
        switch (answer) {
            case 1:
                System.out.print("enter amount to increase: ");
                double amount = scanner.nextDouble();
                double newAccountBalance = passenger.increaseAccountBalance(amount);
                accessToPassengersDB.updateAccountBalance(newAccountBalance, passenger.getId());
                break;
            case 2:
                break;
            default:
                Main.printInvalidInput();
        }
    }

    public void registerOrExit(String userType) throws SQLException {
        System.out.print("1)register\n2)exit\nwhat do you wanna do? : ");
        int answer = scanner.nextInt();
        switch (answer) {
            case 1:
                if (userType.equals("p"))
                    createPassenger(4);
                else
                    createDriver(3);
                break;
            case 2:
                break;
            default:
                Main.printInvalidInput();
        }
    }
}
