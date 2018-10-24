public class WashCard {
    private String carPlateNum;
    private double balance;

    public WashCard(String carPlateNum, double balance) {
        this.carPlateNum = carPlateNum;
        this.balance = balance;
    }

    // getters
    public String getCarPlateNum() {
        return carPlateNum;
    }

    public double getBalance() {
        return balance;
    }

    // setters
    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

}
