import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import Enums.MS;
import Enums.TradeType;
import com.csvreader.CsvReader;

public class Reader {
    public static final String CSV="C:/Users/med_high/Documents/23.csv";
    public static final String TEST_CSV="C:/Users/med_high/Documents/03.02.15.csv";

    public static Trade[] read(String adress) {
        ArrayList<Trade> list = new ArrayList<>();
        try {
            //String adress = "C:/Users/med_high/Documents/23.csv";
            CsvReader csvReader = new CsvReader(adress);

            csvReader.readHeaders();
            int id=Short.MAX_VALUE;
            boolean readEcnTax = false;
            boolean tenFields = false;
            if(csvReader.getHeaderCount()==12) readEcnTax=true;
            if(csvReader.getHeaderCount()==10) tenFields=true;
            while (csvReader.readRecord())
            {
                int i=0;
                String time = csvReader.get(csvReader.getHeader(i++));
                String ticker = csvReader.get(csvReader.getHeader(i++));
                String tradeType = csvReader.get(csvReader.getHeader(i++));
                String price = csvReader.get(csvReader.getHeader(i++));
                String volume = csvReader.get(csvReader.getHeader(i++));
                String route = csvReader.get(csvReader.getHeader(i++));
                String commentary = csvReader.get(csvReader.getHeader(i++));
                String account = csvReader.get(csvReader.getHeader(i++));
                String ms = csvReader.get(csvReader.getHeader(i++));
                String cloid = csvReader.get(csvReader.getHeader(i++));
                if(tenFields){
                    list.add(new Trade()
                            .addElement("time", time)
                            .addElement("ticker", ticker)
                            .addElement("tradetype", tradeType)
                            .addElement("price", price)
                            .addElement("volume", volume)
                            .addElement("route", route)
                            .addElement("commentary", commentary)
                            .addElement("account", account)
                            .addElement("ms", ms)
                            .addElement("cloid", cloid)
                    );
                }
                if(readEcnTax){
                    String ecnTax = csvReader.get(csvReader.getHeader(i++));
                    list.add(new Trade()
                                .addElement("time", time)
                                .addElement("ticker", ticker)
                                .addElement("tradetype", tradeType)
                                .addElement("price", price)
                                .addElement("volume", volume)
                                .addElement("route", route)
                                .addElement("commentary", commentary)
                                .addElement("account", account)
                                .addElement("ms", ms)
                                .addElement("cloid", cloid)
                                .addElement("ecntax", ecnTax)
                                .addElement("id", Integer.toString(id))
                    );
                }else{
                    list.add(new Trade()
                                    .addElement("time", time)
                                    .addElement("ticker", ticker)
                                    .addElement("tradetype", tradeType)
                                    .addElement("price", price)
                                    .addElement("volume", volume)
                                    .addElement("route", route)
                                    .addElement("commentary", commentary)
                                    .addElement("account", account)
                                    .addElement("ms", ms)
                                    .addElement("cloid", cloid)
                                    .addElement("id", Integer.toString(id))
                    );
                }

                /*System.out.println(time + " " + ticker+ " "+tradeType+ " "+price+ " "+volume+ " "+route+ " "+commentary+
                    account+ " "+ms+ " "+cloid+ " "+ecnTax);
                */id--;
            }
            csvReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Trade[] arr = new Trade[list.size()];
        list.toArray(arr);
        return arr;
    }

    public static HashMap<String,ArrayList<Trade>> sortByDeals(Trade[] trades){
        HashMap<String,ArrayList<Trade>> map = new HashMap<>();
        int counter=0;
        HashSet<String> tickerSet = new HashSet<>();
        for(Trade trade:trades){
            tickerSet.add(trade.getTicker());
        }
        for(String str:tickerSet){
            ArrayList<Trade> sameTickerTrades = new ArrayList<>();
            for(Trade trade:trades){
                if(str.equalsIgnoreCase(trade.getTicker())) sameTickerTrades.add(trade);
            }
            map.put(str,sameTickerTrades);
        }
        return map;
    }

    public static Deal[] getArrayOfDeals(HashMap<String,ArrayList<Trade>> map){
        ArrayList<Deal> deals=new ArrayList<>();
        for(Map.Entry<String,ArrayList<Trade>> entry:map.entrySet()){
            if(entry.getValue()!=null) {
                ArrayList<Trade> trades = map.get(entry.getKey());
                Trade[] trr = new Trade[trades.size()];
                trades.toArray(trr);
                if (trr != null) {
                    deals.add(new Deal(trr, trades.get(0).getTime()));
                }
            }
        }
        Deal[] dd=new Deal[deals.size()];
        return deals.toArray(dd);
    }

    public static Deal[] readAndParse(String address){
        return getArrayOfDeals(sortByDeals(read(address)));
    }
}