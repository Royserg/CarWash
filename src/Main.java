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


    // === main ===
    public static void main(String[] args) {
        // populate ArrayList with data
        populateData();
        // show main screen
//        showMainScreen();
        currentCustomer = customers.get(1);
        showUserScreen();
    }


    /** Method that populates program's ArrayList with dummy data */
    private static void populateData() {
        customers.add(new Customer("Michael", "MC6969", "+45 231","1212", 250));
        customers.add(new Customer("Jakub", "JA9991", "+45 123","0000", 600));
        customers.add(new Customer("Sam", "SM7771", "+45 783", "9999", 2000, true));
        customers.add(new Customer("Anna", "AA2211", "+45 223", "9632", 1200, true));
        customers.add(new Customer("Mada", "MA6789", "+45 512","1234", 400, true));

        statistics.add(new Statistic("standard", new Date(), 150.0));
    }

    /** Print Main screen with available options */
    private static void showMainScreen() {
        System.out.println("==== SupremeWash ====");
        System.out.println("1. Register a New User");
        System.out.println("2. Log in");

        // get option from the user
        int option = Helper.chooseOption(1, 2);

        if(option == 1) showRegistrationScreen();
        else showLoginScreen();

    }

    /** Print Login screen  */
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

    /** Print Registration screen */
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
        Customer newCustomer = new Customer(newCustomerInfo[0], newCustomerInfo[1], newCustomerInfo[2], newCustomerInfo[3], amount);

        System.out.println("=== Successfully registered ===");
        // save new Customer into customers ArrayList
        customers.add(newCustomer);

        // Open main page
        showMainScreen();
    }

    /** Print User screen */
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
                int price;

                System.out.println("=== Wash Car ===");

                // show wash car options
                WashType.showOptions();

                int washOption = Helper.chooseOption(1, 3);

                // get amount to pay
                int initialPrice = WashType.getPrice(washOption);
                // apply discount (standard or economy; monday-friday; before 14:00)
                if ((washOption == 1 || washOption == 2) && (dayOfWeek > 1 && dayOfWeek < 7) && hourOfDay < 14 ) {
                    initialPrice *= 0.8;
                }
                // check if customer has enough money
                if (currentCustomer.washCard.getBalance() < initialPrice) {
                    System.out.println("=== Not sufficient funds ===");
                    showUserScreen();
                } else {
                    // reduce customer balance
                    currentCustomer.washCard.changeBalance(-initialPrice);
                    // save wash into statistics
                    Statistic stat = new Statistic(WashType.getName(washOption), today, initialPrice);
                    statistics.add(stat);

                    // print receipt
                    System.out.print("Do you want a receipt?: [y/N]");

                    String decision = scanner.nextLine();

                    if (decision.equals("y")) {
                        System.out.println("=== Your Receipt ===");
                        System.out.println(stat);
                        System.out.println();
                    }

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

                System.out.print("Print statistics: [y/N]");
                String ownerDecision = scanner.nextLine();

                if (ownerDecision.equals("y")) {
                    System.out.println("==== Printing Statistics ====");
                    System.out.println("==== Thank you! ====");
                }

                showUserScreen();
                break;
        }
    }
}
