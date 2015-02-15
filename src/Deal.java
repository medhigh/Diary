import Enums.MS;
import Enums.TradeType;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;

/**
 * Created by med_high on 14.02.2015.
 * Класс содержащий закрытую сделку(открытую и закрытую позицию)
 * или несколько открытых и закрытых позиций завершающих сделку по 1 тикеру
 * (по завершению кол-во товара переходит в 0 или продляеться на средний срок)
 */
public class Deal implements DealType {
    ArrayList<Trade> map;
    Time time; //data
    String ticker;
    TradeType tradeType; //B S SS
    Time openTime; //время открытия
    Time closeTime; //время закрытия
    MS direction; //направление сделки

    long volume; // кол акций
    double averageOpenPrice; //сред. цена открытия
    double averageClosePrice; // сред. цена закрытия
    double ecnTax100; //комисия на 100 акций
    double ecnTax; //общий налог брокера
    double moneyVolumeOpen; //сумма открытия
    double moneyVolumeClose; //сумма закрытия
    double PlGross; //прибыль без налога
    double PlNet; //чистая прибыль (с налогом)
    double volOnStartGross;
    double volOnStartNet;
    double volOnCloseGross;
    double volOnCloseNet;

    public Trade[] getTrades(){
        Trade[] tr = new Trade[map.size()];
        return map.toArray(tr);
    }

    public ArrayList<Trade> getMap() {
        return map;
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

    public Time getOpenTime() {
        return openTime;
    }

    public Time getCloseTime() {
        return closeTime;
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
