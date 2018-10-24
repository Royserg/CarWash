import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // main array storing Customers
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
//        showRegistrationScreen();
        showLoginScreen();
//        showMainScreen();
    }


    /** Method that populates program's ArrayList with dummy data */
    private static void populateData() {
        customers.add(new Customer("Michael", "MC6969", "+45 231","1212", 250));
        customers.add(new Customer("Jakub", "JA9991", "+45 123","0000", 600));
        customers.add(new Customer("Sam", "SM7771", "+45 783", "9999", 2000, true));
        customers.add(new Customer("Anna", "AA2211", "+45 223", "9632", 1200, true));
        customers.add(new Customer("Mada", "MA6789", "+45 512","1234", 400, true));
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


        // consume nextLine form int
        scanner.nextLine();

        if(option == 1) showRegistrationScreen();
        else showLoginScreen();

    }

    /** Print Login screen  */
    public static void showLoginScreen() {
        System.out.println("==== Login ====");

        System.out.println("Type \"exit\" to open main page");
        System.out.print("Car plate Number: ");
        String username = scanner.nextLine().toUpperCase();

        // Coming back to Main page scenario
        if (username.equals("EXIT")) {
            showMainScreen();
            return;
        }

        System.out.print("Password: ");
        String password = scanner.nextLine();

        for (int i = 0; i < customers.size(); i++) {
            if (username.equals(customers.get(i).getCarNumPlate())){
                if (password.equals(customers.get(i).getPassword())) {
                    // user Log in successfully
                    // save as current customer
                    currentCustomer = customers.get(i);
                    // show user screen
                    showUserScreen();
                    return;
                } else {
                    // wrong info provided
                    System.out.println("=== Wrong username or password ===");
                    showLoginScreen();
                }
            }
        }

        // wrong info provided
        System.out.println("=== Wrong username or password ===");
        showLoginScreen();
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
