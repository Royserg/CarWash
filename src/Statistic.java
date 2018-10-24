import java.util.Date;

public class Statistic {

    private String washType;
    private Date date;

    public Statistic(String washType, Date date){
        this.washType = washType;
        this.date = date;
    }

    @Override
    public String toString() {
       return date + " wash: " + washType;
    }

}
