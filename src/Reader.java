import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;

import Enums.MS;
import Enums.TradeType;
import com.csvreader.CsvReader;

public class Reader {

    public static void read(String[] args) {
        try {
            String adress = "C:/Users/med_high/Documents/23.csv";
            CsvReader trades = new CsvReader(adress);

            trades.readHeaders();

            while (trades.readRecord())
            {
                int i=0;
                String time = trades.get(trades.getHeader(i++));
                String ticker = trades.get(trades.getHeader(i++));
                String tradeType = trades.get(trades.getHeader(i++));
                String price = trades.get(trades.getHeader(i++));
                String volume = trades.get(trades.getHeader(i++));
                String route = trades.get(trades.getHeader(i++));
                String commentary = trades.get(trades.getHeader(i++));
                String account = trades.get(trades.getHeader(i++));
                String ms = trades.get(trades.getHeader(i++));
                String cloid = trades.get(trades.getHeader(i++));
                String ecnTax = trades.get(trades.getHeader(i++));

                System.out.println(time + " " + ticker+ " "+tradeType+ " "+price+ " "+volume+ " "+route+ " "+commentary+
                    account+ " "+ms+ " "+cloid+ " "+ecnTax);

            }

            trades.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}