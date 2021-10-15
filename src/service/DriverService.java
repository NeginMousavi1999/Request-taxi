package service;

/**
 * @author Negin Mousavi
 */
public class DriverService {
 /*   public void createDriver(int caseNum, Scanner scanner) throws SQLException, InterruptedException {
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
            if (accessToDriversDB.isObjectFoundByColumnName("drivers", "personal_id", personalId)) {
                System.out.println("you can't register, there is a driver with this personal id!");
                return;
            }
            scanner.nextLine();

            String location;
            do {
                try {
                    System.out.print("enter your location(x,y): ");
                    location = scanner.nextLine();
                    if (location.split(",").length != 2)
                        throw new ArrayIndexOutOfBoundsException();
                    break;
                } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    printInvalidInput();

                }
            } while (true);

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
            drivers[i] = new Driver(personalId, fName, lName, gender, phoneNum, birthYear, typeOfVehicle, vehicleId, location);
            addedSuc += accessToDriversDB.addNewDriver(drivers[i]);
            drivers[i].setId(accessToDriversDB.getId("drivers", "personal_id", personalId));
            System.out.println("id: " + drivers[i].getId());
        }
        if (addedSuc == count)
            System.out.println(count + " new driver(s) were added successfully");
        else
            System.out.println("some thing were wrong...");
    }*/
}
