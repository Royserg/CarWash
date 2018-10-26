public class WashCard {
    private String carPlateNum;
    private double balance;

    public WashCard(String carPlateNum, double balance) {
        this.carPlateNum = carPlateNum;
        this.balance = balance;
    }

    /** Getter
     * @return car plate number  */
    public String getCarPlateNum() {
        return carPlateNum;
    }

    /** Getter
     * @return balance stred on washCard */
    public double getBalance() {
        return balance;
    }

    /** Change balance stored on washCard
     * @param delta - value that balance will be changed by */
    public void changeBalance(double delta) {
        this.balance += delta;
    }

}
