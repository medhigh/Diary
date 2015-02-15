/**
 * Created by med_high on 03.02.2015.
 * Класс содержащий единственную сделку купли или продажи
 */
import Enums.MS;
import Enums.TradeType;

import java.sql.Time;
public class Trade {
    Time time;
    String ticker;
    TradeType tradeType;
    double price;
    long volume;
    String route;
    String commentary;
    String account;
    MS ms;
    String cloid;
    double ecnTax;

    public boolean addElement(String name, String value){
        switch (name){
            case "time":
                this.time = new Time(Integer.parseInt(value.substring(0,2)),Integer.parseInt(value.substring(3,5)),
                        Integer.parseInt(value.substring(4,6)));
                break;
            case "ticker":
                this.ticker = value;
                break;
            case "tradetype":
                if(value.equalsIgnoreCase("b")) this.tradeType=TradeType.B;
                if(value.equalsIgnoreCase("s")) this.tradeType=TradeType.S;
                if(value.equalsIgnoreCase("ss")) this.tradeType=TradeType.SS;
                break;
            case "price":
                this.price=Double.parseDouble(value);
                break;
            case "volume":
                this.volume=Long.parseLong(value);
                break;
            case "route":
                this.route=value;
                break;
            case "commentary":
                this.commentary=value;
                break;
            case "account":
                this.account=value;
                break;
            case "ms":
                if(value.equalsIgnoreCase("margin")) this.ms=MS.Margin;
                if(value.equalsIgnoreCase("short")) this.ms=MS.Short;
                break;
            default: return false;
        }
        return true;
    }
}
