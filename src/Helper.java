import java.util.Scanner;

public class Helper {

    private static Scanner scanner = new Scanner(System.in);

    /** Helper method for changing the balance restricting user from
     * inputing amount less than min and higher than max
     *
     * @attr msg - What message should be displayed on the screen
     * @attr min - minimum allowed value
     * @attr max - maximum allowed value
     *
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
