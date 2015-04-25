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
    Double price;
    Integer volume;
    String route;
    String commentary;
    int id;
    String account;
    MS ms;
    String cloid;
    Double ecnTax;

    public int getId() {
        return id;
    }

    public Time getTime() {
        return time;
    }

    public String getTicker() {
        return ticker;
    }

    public TradeType getTradeType() {
        return tradeType;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getVolume() {
        return volume;
    }

    public String getRoute() {
        return route;
    }

    public String getCommentary() {
        return commentary;
    }

    public String getAccount() {
        return account;
    }

    public MS getMs() {
        return ms;
    }

    public String getCloid() {
        return cloid;
    }

    public Double getEcnTax() {
        return ecnTax;
    }

    public Trade addElement(String name, String value){
        switch (name){
            case "time":
                this.time = new Time(Integer.parseInt(value.substring(0,2)),Integer.parseInt(value.substring(3,5)),
                        Integer.parseInt(value.substring(6,8)));
                break;
            case "ticker":
                this.ticker = value;
                break;
            case "tradetype":
                if(value.equalsIgnoreCase("B")) this.tradeType=TradeType.B;
                if(value.equalsIgnoreCase("S")) this.tradeType=TradeType.S;
                if(value.equalsIgnoreCase("SS")) this.tradeType=TradeType.SS;
                break;
            case "price":
                this.price=Double.parseDouble(value);
                break;
            case "volume":
                this.volume=Integer.parseInt(value);
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
            case "id":
                this.id = Integer.parseInt(value);
                break;
            case "cloid":
                this.cloid=value;
                break;
            case "ecntax":
                this.ecnTax=Double.parseDouble(value);
                break;
            default: return null;
        }
        return this;
    }
}
