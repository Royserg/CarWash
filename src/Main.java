import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Customer> customers = new ArrayList<>();
    // create a Scanner object
    public static Scanner scanner = new Scanner(System.in);
    // holds logged in Customer
    public static Customer currentCustomer;


    // === main ===
    public static void main(String[] args) {
        // populate ArrayList with data
        populateData();

        // display main screen options
        showMainScreen();
    }


    /** Method that populates program's ArrayList with dummy data */
    private static void populateData() {
        customers.add(new Customer("Michael", "MC6969", "+45 231",1212, 100));
        customers.add(new Customer("Jakub", "JA9991", "+45 123",0000, 600));
        customers.add(new Customer("Sam", "SM7771", "+45 783", 9999, 2000, true));
        customers.add(new Customer("Anna", "AA2211", "+45 223", 9632, 1200, true));
        customers.add(new Customer("Mada", "MA6789", "+45 512",1234, 400, true));
    }

    /** Print Main screen available options */
    private static void showMainScreen() {
        System.out.println("==== SupremeWash ====");
        System.out.println("1. Register a New User");
        System.out.println("2. Log in");
        System.out.print("Option: ");

        // collect user input
        int option;

        do {
            while (!scanner.hasNextInt()) {
                System.out.print("Provide a number: ");
                scanner.next();
            }
            option = scanner.nextInt();
        } while (option < 1 || option > 2);


        switch (option) {
            case 1:
                showRegistrationScreen();
                break;
            case 2:
                showLoginScreen();
                break;
            default:
                System.out.println("Can't understand you, MASTER");
        }
    }

    /** Print Login screen  */
    public static void showLoginScreen() {
        System.out.println("==== Login ====");
        // TODO:
        // username:  ...
        // password: ...

        // fail, show loginScreenAgain
        // success, showUserScreen();
    }

    /** Print Registration screen */
    public static void showRegistrationScreen() {
        System.out.println("==== Registration ====");
        // TODO:
        // name, cardPlateNum, phone, ...
    }

    /** Print User screen */
    public static void showUserScreen() {
        String[] options = {"Exit", "Check Balance", "Top-up Balance", "Wash Car", "Generate Statistics"};

        System.out.println("==== Dashboard ====");

        for(int i = 0; i < options.length; i++) {
            if (i == 4 && !currentCustomer.isAdmin) {
                continue;
            }
            System.out.println(i + ". " + options[i]);
        }

        // TODO:
    }

}
