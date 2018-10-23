public class Customer {

    private String name;
    private String carNumberPlate;
    private String phoneNumber;
    private String email;
    private int password;
    private double washCardBalance;

    public Customer (String name, String carNumberPlate, String phoneNumber, String email, int password,double washCardBalance) {
        this.name = name;
        this.carNumberPlate = carNumberPlate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.washCardBalance= washCardBalance;
    }

    public void chargeWashCardBalance(double amount) {
        System.out.println("Charge Balance!");
        this.washCardBalance += amount;
    }

    public void washCar() {
        // params: WashType type
        System.out.println("Washing Car!");
    }


}
