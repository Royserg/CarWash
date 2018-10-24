public class Customer {

    private String name;
//    private String carNumberPlate;
    private String phoneNumber;
    private String password;
    private double washCardBalance;
    public boolean isAdmin = false;

    private WashCard washCard;

    public Customer() {}

    public Customer (String name, String carPlateNum, String phoneNumber, String password, double washCardBalance) {
        this.name = name;
//        this.carNumberPlate = carNumberPlate;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.washCardBalance= washCardBalance;

        // create washCard object
        washCard = new WashCard(carPlateNum);
    }

    public Customer (String name, String carPlateNum, String phoneNumber, String password, double washCardBalance, boolean admin) {
        this(name, carPlateNum, phoneNumber, password, washCardBalance);
        this.isAdmin = admin;
    }

    public void chargeWashCardBalance(double amount) {
        System.out.println("Charge Balance!");
        this.washCardBalance += amount;
        System.out.println("Balance: " + this.washCardBalance);
    }

    /* === getters === */
    public String getCarPlateNum() {
        return washCard.getCarPlateNum();
    }

    public String getPassword() {
        return password;
    }
}
