import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

import java.util.Scanner;

public class Main {

    // main array storing Customers
    private static ArrayList<Customer> customers = new ArrayList<>();
    // ArrayList for Washes
    private static ArrayList<Statistic> statistics = new ArrayList<>();
    // create a Scanner object
    private static Scanner scanner = new Scanner(System.in);
    // holds logged in Customer
    private static Customer currentCustomer;


    public static void main(String[] args) {
        // populate ArrayList with data
        populateData();
        // show main screen
        showMainScreen();
    }


    /**
     * Method that populates program's ArrayList with dummy data
     * Add 5 Customers into customers ArrayList
     * Add 1 Statistic into statistic ArrayList
     * */
    private static void populateData() {
        customers.add(new Customer("Michael", "MC6969", "+45 231","1212", 250));
        customers.add(new Customer("Jakub", "JA9991", "+45 123","0000", 600));
        customers.add(new Customer("Sam", "SM7771", "+45 783", "9999", 2000, true));
        customers.add(new Customer("Anna", "AA2211", "+45 223", "9632", 200, true));
        customers.add(new Customer("Mada", "MA6789", "+45 512","1234", 400, true));

        statistics.add(new Statistic("Standard", new Date(), 150.0));
    }

    /**
     * Shows Main screen with available options
     * Then waits until user chooses an option
     * */
    private static void showMainScreen() {
        System.out.println("==== SupremeWash ====");
        System.out.println("1. Register a New User");
        System.out.println("2. Log in");

        // get option from the user
        int option = Helper.chooseOption(1, 2);

        if(option == 1) showRegistrationScreen();
        else showLoginScreen();

    }

    /**
     * Show Login screen
     * Ask user for Car Plate Number
     * Ask user for password
     * */
    private static void showLoginScreen() {
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
            if (username.equals(customers.get(i).washCard.getCarPlateNum())){
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

    /**
     * Show Registration screen
     * Ask user for details in order to create a new Customer object
     * */
    private static void showRegistrationScreen() {
        double amount;
        System.out.println("==== Registration ====");
        String[] newCustomerInfo = {"Name: ", "Car Plate Number: ", "Mobile Number: ", "Choose your Password: "};

        for (int i = 0; i < newCustomerInfo.length; i++) {
            System.out.print(newCustomerInfo[i]);
            newCustomerInfo[i] = scanner.nextLine();
        }

        amount = Helper.chargeBalance("Charge account with amount between DKK 200-1000: ", 200, 1000);

        System.out.println("=== Payment approved! ===");

        // create a new Customer and add to the arrayList
        Customer newCustomer = new Customer(newCustomerInfo[0], newCustomerInfo[1].toUpperCase(), newCustomerInfo[2], newCustomerInfo[3], amount);

        System.out.println("=== Successfully registered ===");
        // save new Customer into customers ArrayList
        customers.add(newCustomer);

        // Open main page
        showMainScreen();
    }

    /** Show User screen
     * show list of available options for the logged in user of the system
     * if user is an admin, show additionally generating statistics
     * */
    private static void showUserScreen() {
        String[] options = {"Exit", "Check Balance", "Top-up Balance", "Wash Car", "Generate Statistics "};

        System.out.println("==== Dashboard ====");

        for(int i = 0; i < options.length; i++) {
            if (i == 4 && !currentCustomer.isAdmin) {
                continue;
            }
            System.out.println(i + ". " + options[i]);
        }

        // get option from the user
        int option = Helper.chooseOption(0, ( currentCustomer.isAdmin ? 4 : 3 ));

        switch(option) {
            case 0:
                System.out.println("=== Successfully logged out ===");
                System.out.println();
                System.out.println();
                showMainScreen();
                break;
            case 1:
                // print available washCard balance
                System.out.println("=== Balance: " + currentCustomer.washCard.getBalance() + "dkk ==");
                showUserScreen();
                break;
            case 2:
                System.out.println("=== TOP-UP Balance ===");
                // get proper amount
                double amount = Helper.chargeBalance("Choose amount up to 1000dkk: ", 50, 1000);
                // charge balance
                currentCustomer.washCard.changeBalance(amount);
                // feedback
                System.out.println("=== Account charged successfully ===");
                showUserScreen();
                break;
            case 3:
                // create Date
                Date today = new Date();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(today);

                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
                double price;
                boolean isDiscount = ((dayOfWeek > 1 && dayOfWeek < 7) && hourOfDay < 14);
                // store wash type prices
                double[] prices = WashType.getPrices(isDiscount);

                System.out.println("=== Wash Car ===");

                // show wash car options
                System.out.println("1. Economy: " + prices[0]);
                System.out.println("2. Standard: " + prices[1]);
                System.out.println("3. De Luxe: " + prices[2]);

                // get user choice
                int washOption = Helper.chooseOption(1, 3);

                // get amount to pay
                price = prices[washOption - 1];

                // check if customer has enough money
                if (currentCustomer.washCard.getBalance() < price) {
                    System.out.println("=== Insufficient funds ===");
                    showUserScreen();
                } else {
                    // reduce customer balance
                    currentCustomer.washCard.changeBalance(-price);
                    // save wash into statistics
                    Statistic stat = new Statistic(WashType.getName(washOption), today, price);
                    statistics.add(stat);

                    // print receipt
                    System.out.print("Do you want a receipt?: [y/N] ");

                    String decision = scanner.nextLine();

                    if (decision.equals("y")) {
                        System.out.println();
                        System.out.println();
                        System.out.println("=== Your Receipt =========");
                        System.out.println(stat);
                        System.out.println("==============================");
                        System.out.println();
                        System.out.println();
                    }

                    System.out.println("=== Car ready - sending SMS ===");
                    System.out.println();
                    System.out.println();
                    showUserScreen();
                }

                break;
            case 4:
                // Generating statistic
                System.out.println("=== Statistics ===");
                System.out.println();
                for (Statistic stat: statistics) {
                    System.out.println(stat);
                }
                System.out.println();

                System.out.print("Print statistics: [y/N] ");
                String ownerDecision = scanner.nextLine();

                if (ownerDecision.equals("y")) {
                    System.out.println("==== Printing Statistics ====");
                    System.out.println("==== Thank you! ====");
                    System.out.println();
                    System.out.println();
                }

                showUserScreen();
                break;
        }
    }
}
