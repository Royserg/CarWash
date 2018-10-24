public class Customer {

    private String name;
    private String carNumberPlate;
    private String phoneNumber;
    private String password;
    private double washCardBalance;
    public boolean isAdmin = false;

    public Customer() {}

    public Customer (String name, String carNumberPlate, String phoneNumber, String password, double washCardBalance) {
        this.name = name;
        this.carNumberPlate = carNumberPlate;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.washCardBalance= washCardBalance;
    }

    public Customer (String name, String carNumberPlate, String phoneNumber, String password, double washCardBalance, boolean admin) {
        this.name = name;
        this.carNumberPlate = carNumberPlate;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.washCardBalance= washCardBalance;
        this.isAdmin = admin;
    }

    public void chargeWashCardBalance(double amount) {
        System.out.println("Charge Balance!");
        this.washCardBalance += amount;
        System.out.println("Balance: " + this.washCardBalance);
    }

    public void washCar() {
        // params: WashType type
        System.out.println("Washing Car!");
    }

    /* === getters === */
    public String getCarNumPlate() {
        return carNumberPlate;
    }

    public String getPassword() {
        return password;
    }
}
