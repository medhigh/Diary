/**
 * Created by med_high on 18.03.2015.
 */
public class Func extends Functions {
    @Override
    public long getTradedVolume(Deal[] deals) {
        int vol=0;
        for(Deal dd:deals){
            vol+=dd.getVolume();
        }
        return vol;
    }

    @Override
    public int getAlmountDeals(Deal[] deals) {
        int i=0;
        for(Deal dd:deals){
            i++;
        }
        return i;
    }

    @Override
    public double getProfitGross(Deal[] deals) {
        double plGross=0;
        for(Deal dd:deals){
            plGross+=dd.getPlGross();
        }
        return plGross;
    }

    @Override
    public double getProfitNet(Deal[] deals) {
        double plNet=0;
        for(Deal dd:deals){
            plNet+=dd.getPlNet();
        }
        return plNet;
    }

    @Override
    public int getAlmountOfProfitableDeals(Deal[] deals) {
        int i=0;
        for(Deal dd:deals){
            if(dd.getPlNet()>0)i++;
        }
        return i;
    }

    @Override
    public int getAlmountOfUnprofitableDeals(Deal[] deals) {
        int i =0;
        for (Deal dd:deals){
            if(dd.getPlNet()<=0)i++;
        }
        return i;
    }

    @Override
    public double getAverageProfitOfProfitableDeals(Deal[] deals) {
        double profit=0;
        int counter=0;
        for(Deal dd:deals){
            if(dd.getPlNet()>0){
                profit+=dd.getPlNet();
                counter++;
            }
        }
        return profit/counter;
    }

    @Override
    public double getAverageLostOfUnprofitableDeals(Deal[] deals) {
        double profit=0;
        int counter=0;
        for(Deal dd:deals){
            if(dd.getPlNet()<=0){
                profit+=dd.getPlNet();
                counter++;
            }
        }
        return profit/counter;
    }

    @Override
    public double getAverageProfitOfAllDeals(Deal[] deals) {
        double profit=0;
        int counter=0;
        for(Deal dd:deals){
            profit+=dd.getPlNet();
        }
        return profit/counter;
    }

    @Override
    public double getDollarsTraded(Deal[] deals) {
        double traded=0;
        for(Deal dd:deals){
            traded+=Math.abs(dd.getDifferenceOfAveregePrice());
        }
        return Deal.getTruncate(traded,2);
    }

    @Override
    public double getAlmountOfMostProfitableDeal(Deal[] deals) {
        double most=Double.MIN_VALUE;
        for(Deal dd:deals){
            if(dd.getPlNet()>most)most=dd.getPlNet();
        }
        if(most==Double.MIN_VALUE)return 0;
        return most;
    }

    @Override
    public double getAlmountOfMostLostDeal(Deal[] deals) {
        double most=Double.MAX_VALUE;
        for(Deal dd:deals){
            if(dd.getPlNet()<most)most=dd.getPlNet();
        }
        if(most==Double.MAX_VALUE)return 0;
        return most;
    }

    @Override
    public double getProfitOfProfitableDeals(Deal[] deals) {
        double prof=0;
        for(Deal dd:deals){
            if(dd.getPlNet()>0)prof+=dd.getPlNet();
        }
        return prof;
    }

    @Override
    public double getLostOfUnprofitableDeals(Deal[] deals) {
        double lost=0;
        for(Deal dd:deals){
            if(dd.getPlNet()<0)lost+=dd.getPlNet();
        }
        return lost;
    }
}
