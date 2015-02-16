/**
 * Created by med_high on 03.02.2015.
 */
import java.sql.Time;
import java.util.Date;

public class Test {
    public static void main(String args[]){
        Time time = new Time(Date.UTC(2015,02,16,17,40,0));
        Time time2 = new Time(Date.UTC(2015,02,17,17,40,0));
        time.getTime();
    }
}
