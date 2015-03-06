/**
 * Created by med_high on 26.02.2015.
 */
public abstract class Functions {
    /*volume of actions got traded*/
    public abstract long getTradedVolume(Deal[] deals);
    /*almount of deals*/
    public abstract int getAlmountDeals(Deal[] deals);
    /*returns profit without broker tax*/
    public abstract double getProfitGross(Deal[] deals);
    /*returns clear profit with broker tax*/
    public abstract double getProfitNet(Deal[] deals);
    /*almount(returns count of deals) of profitable deal*/
    public abstract int getAlmountOfProfitableDeals(Deal[] deals);
    /*almount(returns count of deals) 0f UnProfitable deals*/
    public abstract int getAlmountOfUnprofitableDeals(Deal[] deals);
    /*average profitable deal*/
    public abstract double getAverageProfitOfProfitableDeals(Deal[] deals);
    /*average unprofitable deal*/
    public  abstract double getAverageLostOfUnprofitableDeals(Deal[] deals);
    /*average profit of all deals*/
    public abstract double getAverageProfitOfAllDeals(Deal[] deals);
    /*points(dollars) traded(volatility catched)*/
    public abstract double getDollarsTraded(Deal[] deals);
    /*almount of most profitable deal*/
    public abstract double getAlmountOfMostProfitableDeal(Deal[] deals);
    /*almount of most lost deal*/
    public abstract double getAlmountOfMostLostDeal(Deal[] deals);
    /*almount of profit(dollars) of all profitable deals*/
    public abstract double getProfitOfProfitableDeals(Deal[] deals);
    /*almount of lost(dollars) of all lost deals*/
    public abstract double getLostOfUnprofitableDeals(Deal[] deals);
}
