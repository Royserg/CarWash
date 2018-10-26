import java.util.Scanner;

public class Helper {

    private static Scanner scanner = new Scanner(System.in);

    /** Helper method for changing the balance restricting user from
     * inputting amount less than min and higher than max
     *
     * @param msg - specify message that will be displayed on the screen - String
     * @param min - minimum allowed value - int
     * @param max - maximum allowed value - int
     * @return selected amount between specified min, max
     * */
    public static double chargeBalance(String msg, int min, int max) {

        double amount;

        System.out.print(msg);

        do {
            while(!scanner.hasNextDouble()) {
                scanner.next();
            }
            amount = scanner.nextDouble();

        } while (amount < min || amount > max);


        return amount;
    }

    /** Helper method that collects user option
     * @param min - minimal allowed option - int
     * @param max - maximal allowed option - int
     * @return selected option between min, max
     * */
    public static int chooseOption(int min, int max) {
        System.out.print("Choose option: ");

        // collect user input
        int option;

        do {
            while (!scanner.hasNextInt()) {
                System.out.print("Provide a number: ");
                scanner.next();
            }
            option = scanner.nextInt();
        } while (option < min || option > max);


        // consume reminding line after collecting integer
        scanner.nextLine();

        return option;
    }
}
