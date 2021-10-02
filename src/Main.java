import java.util.Scanner;

/**
 * @author Negin Mousavi
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        welcome();
        System.out.println("Taxi Agency");
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
                    printStar();
                    break;

                case 2:
                    printStar();
                    break;

                case 3:
                    printStar();
                    break;

                case 4:
                    printStar();
                    break;

                case 5:
                    printStar();
                    break;

                case 6:
                    printStar();
                    break;

                case 7:
                    printStar();
                    break;

                case 8:
                    printStar();
                    break choices;

                default:
                    printInvalidInput();
                    printStar();
                    break;

            }

            break; //TODO
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
}
