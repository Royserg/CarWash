import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {
        // populate ArrayList with dummy Customers and Owner
        populateData();

        Scanner scanner=new Scanner(System.in);

        System.out.println("==== SupremeWash ====");
        System.out.println("1. Register New User");
        System.out.println("2. Log in");
        System.out.print("Option: ");
        // TODO: handle exceptions
        int num = scanner.nextInt();

//        customers.get(2).
    }

    public static void populateData() {
        customers.add(new Customer("Aaron", "AB1234", "+45 512",1234, 200));
        customers.add(new Customer("Jakub", "JA9991", "+45 123",0000, 600));
        customers.add(new Owner("Sam", "SM7771", "+45 783", 9999, 2000));
    }

}
