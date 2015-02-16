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
    ArrayList<Trade> map; //++
    Time time; //data   //++
    String ticker;      //++
    TradeType tradeType; //B S SS ++
    Time openTime; //время открытия ++
    Time closeTime; //время закрытия ++
    MS direction; //направление сделки ++

    boolean notClosed; // не закрытая сделка --
    long volume; // кол акций ++
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
    Trade firstTrade; // first trade of deal ++
    Trade lastTrade; // last trade of deal ++
    public Deal(Trade trade,Time date){

    }

    public Deal(Trade[] trades,Time date){
        for(Trade tr: trades){ //added our trade to collection
            map.add(tr);
        }
        if(!map.isEmpty()){ // looking for null collection
            ticker = map.get(0).getTicker(); // getting ticker
            this.time = date;
            int minId=Short.MAX_VALUE;
            int maxId=0;
            for(Trade tr:map){ //getting lastTrade
                if(tr.getId()>maxId) maxId = tr.getId();
                if(tr.getId()<minId) minId = tr.getId();
            }
            int counterlong=0,countershort=0;
            for(Trade tr:map) {              //getting firstTrade
                if (minId == tr.getId()) firstTrade = tr;
                if (maxId == tr.getId()) lastTrade = tr;
                if (tr.getTradeType()==TradeType.B&&counterlong<tr.getVolume()) counterlong+=tr.getVolume();
                if ((tr.getTradeType()==TradeType.S||tr.getTradeType()==TradeType.SS)&&
                        countershort<tr.getVolume()) countershort+=tr.getVolume();
            }
            tradeType = firstTrade.getTradeType();
            openTime = firstTrade.getTime();
            closeTime = lastTrade.getTime();
            direction = firstTrade.getMs();
            if(counterlong==countershort) {volume=counterlong; notClosed=false; }
            else notClosed=true;
        }else System.out.println("can't get any trade");
    }
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

    public void setTime(Time time) {
        this.time = time;
    }

    public boolean isNotClosed() {
        return notClosed;
    }
}
