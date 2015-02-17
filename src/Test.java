/**
 * Created by med_high on 03.02.2015.
 */
import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String args[]){
        String value = "12.34.56";
        Time tm=new Time(Integer.parseInt(value.substring(0,2)),Integer.parseInt(value.substring(3,5)),
                Integer.parseInt(value.substring(6,8)));
        System.out.print(tm);
        Reader.read();
    }
}
