public class Customer {

    private String name;
    private String phoneNumber;
    private String password;
    public boolean isAdmin = false;

    public WashCard washCard;

    public Customer() {}

    public Customer (String name, String carPlateNum, String phoneNumber, String password, double balance) {
        this.name = name;
//        this.carNumberPlate = carNumberPlate;
        this.phoneNumber = phoneNumber;
        this.password = password;
//        this.washCardBalance= washCardBalance;

        // create washCard object
        washCard = new WashCard(carPlateNum, balance);
    }

    public Customer (String name, String carPlateNum, String phoneNumber, String password, double balance, boolean admin) {
        this(name, carPlateNum, phoneNumber, password, balance);
        this.isAdmin = admin;
    }

    /* === getters === */
    public String getPassword() {
        return password;
    }
}
