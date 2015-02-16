import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;

import Enums.MS;
import Enums.TradeType;
import com.csvreader.CsvReader;

public abstract class Reader {

    public static Trade[] read(String[] args) {
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
                        .addElement("time",time)
                        .addElement("ticker",ticker)
                        .addElement("tradeType",tradeType)
                        .addElement("price",price)
                        .addElement("volume",volume)
                        .addElement("route",route)
                        .addElement("commentary",commentary)
                        .addElement("account",account)
                        .addElement("ms",ms)
                        .addElement("cloid",cloid)
                        .addElement("ecnTax",ecnTax)
                        .addElement("id",Integer.toString(id)));

                System.out.println(time + " " + ticker+ " "+tradeType+ " "+price+ " "+volume+ " "+route+ " "+commentary+
                    account+ " "+ms+ " "+cloid+ " "+ecnTax);
                System.out.println("ID="+id);
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

    public abstract ArrayList<Deal> sortByDeals(Trade[] trades);

}