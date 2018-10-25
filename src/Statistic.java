import java.util.Date;

public class Statistic {

    private String washType;
    private Date date;
    private double price;

    public Statistic(String washType, Date date, double price){
        this.washType = washType;
        this.date = date;
        this.price = price;
    }

    @Override
    public String toString() {
       return "Date: " + date + " |wash: " + washType + " |price: " + price;
    }

}
