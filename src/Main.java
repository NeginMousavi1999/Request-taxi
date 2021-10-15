import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Negin Mousavi
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InterruptedException {
        TaxiManager taxiManager = new TaxiManager();
        welcome();
        int choice;

        choices:
        do {
            System.out.print("choose from below:\n" +
                    "1.Add a group of drivers  \n" +
                    "2.Add a group of passengers  \n" +
                    "3.Driver signup or login  \n" +
                    "4.Passenger signup or login  \n" +
                    "5.Show ongoing travels  \n" +
                    "6.Show a list of drivers \n" +
                    "7.Show a list of passengers\n" +
                    "8.exit\n" +
                    "your choice is: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    taxiManager.createDriver(1);
                    printStar();
                    break;

                case 2:
                    taxiManager.createPassenger(2);
                    printStar();
                    break;

                case 3:
                    taxiManager.signupOrLogin(3);
                    printStar();
                    break;

                case 4:
                    taxiManager.signupOrLogin(4);
                    printStar();
                    break;

                case 5:
                    taxiManager.showAllOngoingTravels();
                    printStar();
                    break;

                case 6:
                    taxiManager.showAllDrivers();
                    printStar();
                    break;

                case 7:
                    taxiManager.showAllPassengers();
                    printStar();
                    break;

                case 8:
                    printStar();
                    break choices;

                default:
                    printInvalidInput();
                    printStar();
            }

        } while (true);
    }

    public static void printInvalidInput() {
        System.out.println("invalid input");
    }

    public static void printStar() {
        System.out.println("**********************************************************");
    }

    public static void welcome() {
        System.out.println("  _______         _                                          \n" +
                " |__   __|       (_)        /\\                               \n" +
                "    | | __ ___  ___        /  \\   __ _  ___ _ __   ___ _   _ \n" +
                "    | |/ _` \\ \\/ / |      / /\\ \\ / _` |/ _ \\ '_ \\ / __| | | |\n" +
                "    | | (_| |>  <| |     / ____ \\ (_| |  __/ | | | (__| |_| |\n" +
                "    |_|\\__,_/_/\\_\\_|    /_/    \\_\\__, |\\___|_| |_|\\___|\\__, |\n" +
                "                                  __/ |                 __/ |\n" +
                "                                 |___/                 |___/ ");
    }

 /*   public static User returnUserWithCommonInfo() throws InterruptedException {
        scanner.nextLine();
        System.out.print("first name: ");
        String fName = scanner.nextLine();

        System.out.print("last name: ");
        String lName = scanner.nextLine();

        System.out.print("personal id: ");
        String personalId = scanner.nextLine();

        Gender gender;
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

        String phoneNum;
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

        int birthYear;
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
        return new User(personalId, fName, lName, gender, phoneNum, birthYear);
    }
    public static void handleExceptionForMobileNumFormat(String input) {
        String regex = "09[0-9]{9}";
        if (!Pattern.matches(regex, input))
            throw new UserInputValidation("some thing is not correct about this phone number");
    }*/
}
