public class WashType {

    public static double economyPrice = 50.0;
    public static double standardPrice = 80.0;
    public static double deluxePrice = 120.0;

    public static double[] getPrices(boolean discount) {
        double[] prices = new double[3];

        // apply discount if necessary
        prices[0] = discount ? economyPrice * 0.8 : economyPrice;
        prices[1] = discount ? standardPrice * 0.8 : standardPrice;
        prices[2] = deluxePrice;

        return prices;
    }


    public static String getName(int option) {
        switch (option){
            case 1:
                return "Economy";
            case 2:
                return "Standard";
            case 3:
                return "De Luxe";
            default:
                return "";
        }
    }
}