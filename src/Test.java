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
        int i =0;
//        System.out.println(ff.getProfitNet(Reader.readAndParse("C:/Users/med_high/Documents/03.02.15.csv"))+" ProfitNet"+" was "+i+++"file");
//        System.out.println(ff.getProfitNet(Reader.readAndParse("C:/Users/med_high/Documents/04.02.15.csv"))+" ProfitNet"+" was "+i+++"file");
//        System.out.println(ff.getProfitNet(Reader.readAndParse("C:/Users/med_high/Documents/11.02.15.csv"))+" ProfitNet"+" was "+i+++"file");
//        System.out.println(ff.getProfitNet(Reader.readAndParse("C:/Users/med_high/Documents/13.02.15.csv"))+" ProfitNet"+" was "+i+++"file");
//        System.out.println(ff.getProfitNet(Reader.readAndParse("C:/Users/med_high/Documents/16.03.15.csv"))+" ProfitNet"+" was "+i+++"file");
//        System.out.println(ff.getProfitNet(Reader.readAndParse("C:/Users/med_high/Documents/17.02.15.csv"))+" ProfitNet"+" was "+i+++"file");
//        System.out.println(ff.getProfitNet(Reader.readAndParse("C:/Users/med_high/Documents/19.03.15.csv"))+" ProfitNet"+" was "+i+++"file");
//        System.out.println(ff.getProfitNet(Reader.readAndParse("C:/Users/med_high/Documents/27.02.15.csv"))+" ProfitNet"+" was "+i+++"file");
//        System.out.println(ff.getProfitNet(Reader.readAndParse("C:/Users/med_high/Documents/28.01.csv"))+" ProfitNet"+"was "+i+++"file");
//        System.out.println(ff.getProfitNet(Reader.readAndParse("C:/Users/med_high/Documents/29.01.csv"))+" ProfitNet"+"was "+i+++"file");
        System.out.println(ff.getProfitNet(Reader.readAndParse("C:/Users/med_high/Desktop/24.04.15.csv"))+" ProfitNet"+"was "+i+++"file");
        System.out.println(ff.getDollarsTraded(Reader.readAndParse("C:/Users/med_high/Desktop/24.04.15.csv"))+" Dollars traded "+"was "+i+++"file");
        System.out.println(ff.getProfitNet(Reader.readAndParse("C:/Users/med_high/Desktop/123.csv"))+" ProfitNet"+"was "+i+++"file");
        System.out.println(ff.getDollarsTraded(Reader.readAndParse("C:/Users/med_high/Desktop/123.csv"))+" Dollars traded "+"was "+i+++"file");
    }
}
