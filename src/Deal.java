import Enums.MS;
import Enums.TradeType;

import java.sql.Time;
import java.util.Collection;
import java.util.TreeMap;

/**
 * Created by med_high on 14.02.2015.
 * Класс содержащий закрытую сделку(открытую и закрытую позицию)
 * или несколько открытых и закрытых позиций завершающих сделку по 1 тикеру
 * (по завершению кол-во товара переходит в 0 или продляеться на средний срок)
 */
public class Deal implements DealType {
    TreeMap<Float,Trade> map;
    Time time; //data
    String ticker;
    TradeType tradeType;
    Time open;
    Time close;
    MS direction;
    long volume;
    double averageOpenPrice;
    double averageClosePrice;
    double ecnTax100;
    double ecnTax;
    double moneyVolumeOpen;
    double moneyVolumeClose;
    double PlGross;
    double PlNet;
    double volOnStartGross;
    double volOnStartNet;
    double volOnCloseGross;
    double volOnCloseNet;

    public TreeMap<Float, Trade> getMap() {
        return map;
    }

    public Collection<Trade> getTrades(){
        return map.values();
    }

    @Override
    public Time getTime() {
        return time;
    }

    @Override
    public String getTicker() {
        return ticker;
    }

    @Override
    public TradeType getTradeType() {
        return tradeType;
    }

    public Time getOpen() {
        return open;
    }

    public Time getClose() {
        return close;
    }

    @Override
    public MS getDirection() {
        return direction;
    }

    @Override
    public long getVolume() {
        return volume;
    }

    public double getAverageOpenPrice() {
        return averageOpenPrice;
    }

    public double getAverageClosePrice() {
        return averageClosePrice;
    }

    @Override
    public double getEcnTax100() {
        return ecnTax100;
    }

    @Override
    public double getEcnTax() {
        return ecnTax;
    }

    @Override
    public double getMoneyVolumeOpen() {
        return moneyVolumeOpen;
    }

    @Override
    public double getMoneyVolumeClose() {
        return moneyVolumeClose;
    }

    @Override
    public double getPlGross() {
        return PlGross;
    }

    @Override
    public double getPlNet() {
        return PlNet;
    }

    @Override
    public double getVolOnStartGross() {
        return volOnStartGross;
    }

    @Override
    public double getVolOnStartNet() {
        return volOnStartNet;
    }

    @Override
    public double getVolOnCloseGross() {
        return volOnCloseGross;
    }

    @Override
    public double getVolOnCloseNet() {
        return volOnCloseNet;
    }
}
