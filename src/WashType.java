public class WashType {

    public static int economyPrice = 50;
    public static int standardPrice = 80;
    public static int deluxePrice = 120;

    public static void showOptions() {
        // TODO: showing prices with discount
        System.out.println("1. Standard - " + standardPrice + "dkk");
        System.out.println("2. Economy - " + economyPrice + "dkk");
        System.out.println("3. De Luxe - " + deluxePrice + "dkk");
    }

    public static int getPrice(int option) {
        switch (option){
            case 1:
                return standardPrice;
            case 2:
                return economyPrice;
            case 3:
                return deluxePrice;
            default:
                return 0;
        }
    }

    public static String getName(int option) {
        switch (option){
            case 1:
                return "Standard";
            case 2:
                return "Economy";
            case 3:
                return "De Luxe";
            default:
                return "";
        }
    }




}