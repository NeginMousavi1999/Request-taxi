import accesstodb.AccessToDriversDB;
import accesstodb.AccessToPassengersDB;
import accesstodb.AccessToTripDB;
import accesstodb.AccessToVehicleDB;
import enumeration.Gender;
import enumeration.PaymentMethod;
import enumeration.TypeOfVehicle;
import exceptions.UserInputValidation;
import models.members.Driver;
import models.members.Passenger;
import models.members.User;
import models.trip.Trip;
import models.vehicles.Vehicle;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author Negin Mousavi
 */
public class TaxiManager {
    Scanner scanner = new Scanner(System.in);
    AccessToPassengersDB accessToPassengersDB = new AccessToPassengersDB();
    AccessToDriversDB accessToDriversDB = new AccessToDriversDB();
    AccessToVehicleDB accessToVehicleDB = new AccessToVehicleDB();
    AccessToTripDB accessToTripDB = new AccessToTripDB();
    private String fName, lName, personalId, phoneNum;
    private int birthYear;
    Gender gender;
    PaymentMethod paymentMethod;
    String origin, destination;

    public TaxiManager() throws SQLException, ClassNotFoundException {
    }

    public void createDriver(int caseNum) throws SQLException, InterruptedException {
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
            if (accessToDriversDB.isObjectFound("drivers", "personal_id", personalId)) {
                System.out.println("you can't register, there is a driver with this personal id!");
                return;
            }
            scanner.nextLine();

            String vehiclePlaque = null;
            while (true) {
                try {
                    System.out.print("vehicle plaque: ");
                    vehiclePlaque = scanner.nextLine();
                    handleExceptionForPlaqueFormat(vehiclePlaque);
                    break;
                } catch (Exception e) {
                    System.out.println(e.getLocalizedMessage());
                    Thread.sleep(1000);
                }
            }

            TypeOfVehicle typeOfVehicle;
            int vehicleId;
            if (isVehiclePlaqueExists(vehiclePlaque)) {
                System.out.println("you can choose this vehicle plaque because it is exits already...");
                return;
            } else {
                do {
                    typeOfVehicle = chooseTypeOfVehicle();
                } while (typeOfVehicle == null);
                scanner.nextLine();
                System.out.print("vehicle name: ");
                String name = scanner.nextLine();
                System.out.print("vehicle color: ");
                String color = scanner.nextLine();
                vehicleId = createVehicleAndReturnId(name, color, vehiclePlaque, typeOfVehicle);
            }
            drivers[i] = new Driver(personalId, fName, lName, gender, phoneNum, birthYear, typeOfVehicle, vehicleId);
            addedSuc += accessToDriversDB.addNewDriver(drivers[i]);
            drivers[i].setId(accessToDriversDB.getId("drivers", "personal_id", personalId));
            System.out.println("id: " + drivers[i].getId());
        }
        if (addedSuc == count)
            System.out.println(count + " new driver(s) were added successfully");
        else
            System.out.println("some thing were wrong...");
    }

    public TypeOfVehicle chooseTypeOfVehicle() {
        TypeOfVehicle typeOfVehicle = null;
        System.out.print("which vehicle you have? (1.car 2.van 3.motorcycle) : ");
        int chosenTypeOfVehicle = scanner.nextInt();
        switch (chosenTypeOfVehicle) {
            case 1:
                typeOfVehicle = TypeOfVehicle.CAR;
                break;

            case 2:
                typeOfVehicle = TypeOfVehicle.VAN;
                break;

            case 3:
                typeOfVehicle = TypeOfVehicle.MOTORCYCLE;
                break;

            default:
                Main.printInvalidInput();
        }
        return typeOfVehicle;
    }

    private int createVehicleAndReturnId(String name, String color, String plaque, TypeOfVehicle typeOfVehicle) throws SQLException {
        Vehicle vehicle = new Vehicle(name, color, plaque, typeOfVehicle);
        accessToVehicleDB.addNewVehicle(vehicle);
        vehicle.setId(accessToVehicleDB.getId("vehicles", "plaque", plaque));
        return vehicle.getId();
    }

    private boolean isVehiclePlaqueExists(String vehiclePlaque) throws SQLException {
        return accessToDriversDB.isObjectFound("vehicles", "plaque", vehiclePlaque);
    }

    public void createPassenger(int caseNum) throws SQLException, InterruptedException {
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
            if (accessToPassengersDB.isObjectFound("passengers", "personal_id", personalId)) {
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

    public void getCommonInformationInputs() throws InterruptedException {
        scanner.nextLine();
        System.out.print("first name: ");
        fName = scanner.nextLine();

        System.out.print("last name: ");
        lName = scanner.nextLine();

        System.out.print("personal id: ");
        personalId = scanner.nextLine();

        while (true) {
            try {
                System.out.print("gender(female/male): ");
                gender = Gender.valueOf(scanner.nextLine().toUpperCase());
                break;
            } catch (UserInputValidation | NullPointerException | IllegalArgumentException e) {
                System.out.println("you must enter female or male...");
                Thread.sleep(1000);
            }
        }

        while (true) {
            try {
                System.out.print("phone number: ");
                phoneNum = scanner.nextLine();
                handleExceptionForMobileNumFormat(phoneNum);
                break;
            } catch (UserInputValidation e) {
                System.out.println(e.getLocalizedMessage());
                Thread.sleep(1000);
            }
        }

        while (true) {
            System.out.print("birth year: ");
            if (scanner.hasNextInt()) {
                birthYear = scanner.nextInt();
                break;
            } else {
                scanner.nextLine();
                System.out.println("Enter a valid Integer value");
                Thread.sleep(1000);
            }
        }
    }

    public static void handleExceptionForMobileNumFormat(String input) {
        String regex = "09[0-9]{9}";
        if (!Pattern.matches(regex, input))
            throw new UserInputValidation("some thing is not correct about this phone number");
    }

    public static void handleExceptionForPlaqueFormat(String input) {
        String regex = "[0-9]{2}[a-z][0-9]{2}";
        if (!Pattern.matches(regex, input))
            throw new UserInputValidation("the format of plauqe must be like: 99x99");
    }

    public void showAllPassengers() throws SQLException {
        accessToPassengersDB.showAllObjectsInDB();
    }

    public void showAllDrivers() throws SQLException {
        accessToDriversDB.showAllObjectsInDB();
    }

    public void signupOrLogin(int caseNum) throws SQLException, InterruptedException {
        System.out.print("enter your Personal Id: ");
        String inputPersonalId = scanner.nextLine();
        if (caseNum == 3) {
            User driver = accessToDriversDB.returnUserIfExists("drivers", "personal_id", inputPersonalId);
            if (driver == null)
                registerOrExit("d");
            else {
                System.out.print("you are authenticated ");
                if (!driver.isTripStatus())
                    System.out.println("and waiting for the trip");
                else {

                }
            }

        } else if (caseNum == 4) {
            User passenger = accessToPassengersDB.returnUserIfExists("passengers", "personal_id", inputPersonalId);
            if (passenger == null)
                registerOrExit("p");
            else {
                if (!passenger.isTripStatus())
                    showPassengerLoginMenu((Passenger) passenger);
                else {//TODO

                }

            }
        }
    }

    public void showTripDetails() {

    }

    public void OptionsForDriverWhileTraveling() {
        System.out.print("1.Confirm cash receipt\n2.Travel finished\n3.Exit\nwhat do you wanna do? : ");
        int chosenOption = scanner.nextInt();
        switch (chosenOption) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                Main.printInvalidInput();
        }
    }

    public void confirmTravelFinished() {

    }

    public void registerOrExit(String userType) throws SQLException, InterruptedException {
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
                scanner.nextLine();
                break;
            default:
                Main.printInvalidInput();
        }
    }

    public void showPassengerLoginMenu(Passenger passenger) throws SQLException, InterruptedException {
        while (true) {
            System.out.print("you are authenticate\n1)Travel request (cash payment)\n2.Travel request (payment from account balance)\n" +
                    "3.Increase account balance\n4)Exit\nwhat do you wanna do? : ");
            int answer = scanner.nextInt();
            if (answer == 1 || answer == 2) {
                int cost = setOriginAndDestinationAndReturnCost();
                System.out.println("cost is: " + cost);
                if (answer == 2) {
                    if (cost > passenger.getAccountBalance()) {
                        System.out.print("the cost is more than account balance. do you wanna choose something else?(y or n): ");
                        String showAgainOrCancel = scanner.nextLine();
                        if (!showAgainOrCancel.equals("y"))
                            break;
                        else continue;

                    }
                    paymentMethod = PaymentMethod.ACCOUNT_BALANCE;
                } else
                    paymentMethod = PaymentMethod.CASH;

                Trip trip = new Trip(passenger.getId(), origin, destination, cost, paymentMethod);
                System.out.println("wait until driver accept....");
                Thread.sleep(3000);
                Driver accDriver = findNearestDriverByPersonalId();
                trip.setDriverId(accDriver.getId());
                
                accessToDriversDB.updateTripStatus(accDriver, true);
                accessToPassengersDB.updateTripStatus(passenger, true);
                accessToTripDB.updateTripStatus(trip, true);

                accessToTripDB.addNewTrip(trip);
                break;

            } else if (answer == 3) {
                System.out.print("enter amount to increase: ");
                double amount = scanner.nextDouble();
                double newAccountBalance = passenger.increaseAccountBalance(amount);
                accessToPassengersDB.updateAccountBalance(newAccountBalance, passenger.getId());
                break;

            } else if (answer == 4)
                break;

            else
                Main.printInvalidInput();
        }
    }

    public int setOriginAndDestinationAndReturnCost() {
        scanner.nextLine();
        System.out.print("enter coordinates of origin(split with ',' ): ");
        origin = scanner.nextLine();
        System.out.print("enter coordinates of destination(split with ',' ): ");
        destination = scanner.nextLine();
        int cost = calculateTheDistanceBetweenTwoPoints(origin, destination) * 1000;
        return cost;
    }

    public int calculateTheDistanceBetweenTwoPoints(String a, String b) {
        int space;
        int xO = Integer.parseInt(a.split(",")[0]);
        int yO = Integer.parseInt(a.split(",")[1]);
        int xD = Integer.parseInt(b.split(",")[0]);
        int yD = Integer.parseInt(b.split(",")[1]);
        int c = xD - xO;
        int d = yD - yO;
        space = (int) Math.sqrt(Math.pow(c, 2) + Math.pow(d, 2));
        return space;
    }

    public Driver findNearestDriverByPersonalId() throws SQLException {
        List<String> locations = accessToDriversDB.findLocation();
        int min = Integer.MAX_VALUE;
        String dLocation = null;
        for (String location : locations) {
            int space = calculateTheDistanceBetweenTwoPoints(location, origin);
            if(space < min) {
                min = space;
                dLocation = location;
            }
        }
        User driver = accessToDriversDB.returnUserIfExists("drivers", "location", dLocation);
        return (Driver) driver;
    }
}