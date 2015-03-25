/**
 * Created by med_high on 03.02.2015.
 */
import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String args[]){
        Func ff = new Func();
        System.out.println(ff.getProfitNet(Reader.readAndParse(Reader.CSV))+" ProfitNet");
    }
}
