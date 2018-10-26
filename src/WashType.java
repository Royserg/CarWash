public class WashType {

    private static double economyPrice = 50.0;
    private static double standardPrice = 80.0;
    private static double deluxePrice = 120.0;

    /**
     * Pull prices of all wash types, reduced by 20% if applicable
     * @param discount - true if it is discounted period, false otherwise
     * @return array of doubles - prices of Washes
     * */
    public static double[] getPrices(boolean discount) {
        double[] prices = new double[3];

        // apply discount if necessary
        prices[0] = discount ? economyPrice * 0.8 : economyPrice;
        prices[1] = discount ? standardPrice * 0.8 : standardPrice;
        prices[2] = deluxePrice;

        return prices;
    }

    /** Give back the name of the particular washType
     * @param option - integer from 1 to 3
     * @return name of the washType
     * */
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