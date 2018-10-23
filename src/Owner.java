import java.util.Date;

public class Owner extends Customer {
    private String[] options = {"Check Balance", "Top-up the Balance", "Wash Car", "Generate Statistics"};

    public Owner() {};
    public Owner(String name, String carNumberPlate, String phoneNumber, int password,double washCardBalance) {
        super(name, carNumberPlate, phoneNumber, password, washCardBalance);
    }

    public void generateStatistics(Date startDate, Date endDate) {
        System.out.println("Generating Stats");
    }
}
