import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

import Enums.MS;
import Enums.TradeType;
import com.csvreader.CsvReader;

public class Reader {

    public static Trade[] read() {
        ArrayList<Trade> list = new ArrayList<>();
        try {
            String adress = "C:/Users/med_high/Documents/23.csv";
            CsvReader csvReader = new CsvReader(adress);

            csvReader.readHeaders();
            int id=Short.MAX_VALUE;

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
                                .addElement("id",Integer.toString(id))
                );

                System.out.println(time + " " + ticker+ " "+tradeType+ " "+price+ " "+volume+ " "+route+ " "+commentary+
                    account+ " "+ms+ " "+cloid+ " "+ecnTax);
                id--;
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
        ArrayList<>
        String ticker="123123123";
        for(int i=0;i<trades.length;i++){

        }
    }

}