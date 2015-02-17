import Enums.MS;
import Enums.TradeType;

import java.sql.Time;
import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by med_high on 14.02.2015.
 * Класс содержащий закрытую сделку(открытую и закрытую позицию)
 * или несколько открытых и закрытых позиций завершающих сделку по 1 тикеру
 * (по завершению кол-во товара переходит в 0 или продляеться на средний срок)
 */
public class Deal implements DealType {
    ArrayList<Trade> map; //++
    Time time; //date   //++
    String ticker;      //++
    TradeType tradeType; //B S SS ++
    Time openTime; //время открытия ++
    Time closeTime; //время закрытия ++
    MS direction; //направление сделки ++

    boolean notClosed; // не закрытая сделка ++
    int volume; // кол акций ++
    double averageOpenPrice; //сред. цена открытия // ++
    double averageClosePrice; // сред. цена закрытия //++
    double dealedAveregePriceVolume; //difference of averageOpen/ClosePrice*volume ++
    double differenceOfAveregePrice; //difference of averageOpen/ClosePrice ++
    double ecnTax100; //комисия на 100 акций //--
    double ecnTax; //общий налог брокера // ++
    double moneyVolumeOpen; //сумма открытия //++
    double moneyVolumeClose; //сумма закрытия //++
    double PlGross; //прибыль без налога ++
    double PlNet; //чистая прибыль (с налогом) ++
    double volOnStartGross;
    double volOnStartNet;
    double volOnCloseGross;
    double volOnCloseNet;
    Trade firstTrade; // first trade of deal ++
    Trade lastTrade; // last trade of deal ++
    public Deal(Trade trade,Time date){

    }

    public Deal(Trade[] trades,Time date){ //!!! need to set date ecnTax100 and 4 fields;
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
            HashMap<Double,Integer> priceB=new HashMap<>();
            HashMap<Double,Integer> priceS=new HashMap<>();
            int counterlong=0,countershort=0;
            ecnTax=0;
            double moneyVolumeB=0,moneyVolumeS=0;
            for(Trade tr:map) {              //getting firstTrade
                if (minId == tr.getId()) firstTrade = tr;
                if (maxId == tr.getId()) lastTrade = tr;
                if (tr.getTradeType()==TradeType.B&&counterlong<tr.getVolume()) {
                    counterlong+=tr.getVolume();
                }
                if ((tr.getTradeType()==TradeType.S||tr.getTradeType()==TradeType.SS)&&
                        countershort<tr.getVolume()) {
                    countershort+=tr.getVolume();
                }
                if (tr.getTradeType()==TradeType.B){
                    priceB.put(tr.getPrice(),tr.getVolume());
                    moneyVolumeB+=tr.getVolume()*tr.getPrice();
                }
                if ((tr.getTradeType()==TradeType.S||tr.getTradeType()==TradeType.SS)){
                    priceS.put(tr.getPrice(),tr.getVolume());
                    moneyVolumeS+=tr.getVolume()*tr.getPrice();
                }
                ecnTax+=tr.getEcnTax();
            }
            tradeType = firstTrade.getTradeType();
            openTime = firstTrade.getTime();
            closeTime = lastTrade.getTime();
            direction = firstTrade.getMs();
            if(counterlong==countershort) {
                volume=counterlong; notClosed=false; }
            else {
                notClosed=true; volume=counterlong<countershort?countershort:counterlong;
            }
            if(firstTrade.getTradeType()==TradeType.B){
                averageOpenPrice=calcAveragePrice(priceB);
                averageClosePrice=calcAveragePrice(priceS);
                moneyVolumeOpen=moneyVolumeB;
                moneyVolumeClose=moneyVolumeS;
                dealedAveregePriceVolume =getTruncate((averageClosePrice-averageOpenPrice)*volume,2);
                differenceOfAveregePrice=averageClosePrice-averageOpenPrice;
                PlGross = moneyVolumeClose-moneyVolumeOpen;}
            if(firstTrade.getTradeType()==TradeType.SS){
                averageOpenPrice=calcAveragePrice(priceS);
                averageClosePrice=calcAveragePrice(priceB);
                moneyVolumeOpen=moneyVolumeS;
                moneyVolumeClose=moneyVolumeB;
                dealedAveregePriceVolume =getTruncate((averageOpenPrice-averageClosePrice)*volume,2);
                differenceOfAveregePrice=averageOpenPrice-averageClosePrice;
                PlGross = moneyVolumeOpen-moneyVolumeClose;}
            if(firstTrade.getTradeType()==TradeType.S) {
                System.out.println("Something goes wrong on Trade Type S " +
                        "in firsTrade!!!or first trade was in not closed deal!");
                System.out.println("FIRST TRADE WAS: ");
                System.out.println(firstTrade.time + " " + firstTrade.ticker+ " "+firstTrade.tradeType+
                        " "+firstTrade.price+ " "+volume+ " "+firstTrade.route+ " "+firstTrade.commentary+
                        firstTrade.account+ " "+firstTrade.ms+ " "+firstTrade.cloid+ " "+ecnTax+" "+firstTrade.id);
                //moneyVolumeOpen = moneyVolumeB;
                //moneyVolumeClose = moneyVolumeS;
            }
            PlNet=PlGross-ecnTax;
        }else System.out.println("can't get any trade");
    }

    public static double calcAveragePrice(HashMap<Double,Integer> map){
        double sumall=0,sumval=0;
        for(Map.Entry<Double,Integer> entry:map.entrySet()){
            sumall+=entry.getKey()*entry.getValue();
            sumval+=entry.getValue();
        }
        return  sumall/sumval;
    }
    public static double getTruncate(double value,int amOfSymbols){
        double newDouble = new BigDecimal(value).setScale(amOfSymbols, RoundingMode.UP).doubleValue();
        return  newDouble;
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
    public int getVolume() {
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
