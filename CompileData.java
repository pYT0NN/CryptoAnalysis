import java.io.IOException;
public class CompileData {

static String[] in = new String[200];
static String line = " ";
static int length;
static int x = 0; //Zähler damit man durch das gesamte Array des inputs geht

public static Crypto[] makeCrypto() throws IOException {
        Crypto[] out = new Crypto[10];
        download();

        for(int i = 0; i < 10; i++) {
                getCurrentLine(i);

                //Werte aus der Zeile auslesen, je nachdem wo releavante Infos anfangen und aufhören
                String id = line.substring(6, length - 3);
                getCurrentLine(i);
                String name = line.substring(8, length - 3);
                getCurrentLine(i);
                String symbol = line.substring(10, length - 3);
                getCurrentLine(i);
                // System.out.println(line); //Errortest
                // System.out.println("x = " + x);
                // System.out.println("i = " + i);
                int rank = Integer.parseInt(line.substring(8, length - 3));
                getCurrentLine(i);
                double price_usd = Double.parseDouble(line.substring(13, length - 3));
                getCurrentLine(i);
                double price_btc = Double.parseDouble(line.substring(13, length - 3));
                getCurrentLine(i);
                int volume = Integer.parseInt(line.substring(18, length - 4)); //hier aktueller error
                getCurrentLine(i);
                int market_cap = Integer.parseInt(line.substring(18, length - 3));
                getCurrentLine(i);
                int available_supply = Integer.parseInt(line.substring(20, length - 5));
                getCurrentLine(i);
                int total_supply = Integer.parseInt(line.substring(16, length - 5));
                getCurrentLine(i);
                int max_supply = Integer.parseInt(line.substring(14, length - 5));
                getCurrentLine(i);
                float percent_change_1h = Float.parseFloat(line.substring(21, length - 3));
                getCurrentLine(i);
                float percent_change_24h = Float.parseFloat(line.substring(22, length - 3));
                getCurrentLine(i);
                float percent_change_7d  = Float.parseFloat(line.substring(21, length - 3));
                getCurrentLine(i);
                long last_updated  = Long.parseLong(line.substring(16, length - 2));
                getCurrentLine(i);


                //Coin Objecte mit den Werten initialisieren

                if(x == 15) out[0] = new Crypto(id, name, symbol, rank, price_usd, price_btc, volume, market_cap, available_supply, total_supply, max_supply, percent_change_1h, percent_change_24h, percent_change_7d, last_updated);
                else if(x == 30) out[1] = new Crypto(id, name, symbol, rank, price_usd, price_btc, volume, market_cap, available_supply, total_supply, max_supply, percent_change_1h, percent_change_24h, percent_change_7d, last_updated);
                else if(x == 45) out[2] = new Crypto(id, name, symbol, rank, price_usd, price_btc, volume, market_cap, available_supply, total_supply, max_supply, percent_change_1h, percent_change_24h, percent_change_7d, last_updated);
                else if(x == 60) out[3] = new Crypto(id, name, symbol, rank, price_usd, price_btc, volume, market_cap, available_supply, total_supply, max_supply, percent_change_1h, percent_change_24h, percent_change_7d, last_updated);
                else if(x == 75) out[4] = new Crypto(id, name, symbol, rank, price_usd, price_btc, volume, market_cap, available_supply, total_supply, max_supply, percent_change_1h, percent_change_24h, percent_change_7d, last_updated);
                else if(x == 90) out[5] = new Crypto(id, name, symbol, rank, price_usd, price_btc, volume, market_cap, available_supply, total_supply, max_supply, percent_change_1h, percent_change_24h, percent_change_7d, last_updated);
                else if(x == 105) out[6] = new Crypto(id, name, symbol, rank, price_usd, price_btc, volume, market_cap, available_supply, total_supply, max_supply, percent_change_1h, percent_change_24h, percent_change_7d, last_updated);
                else if(x == 120) out[7] = new Crypto(id, name, symbol, rank, price_usd, price_btc, volume, market_cap, available_supply, total_supply, max_supply, percent_change_1h, percent_change_24h, percent_change_7d, last_updated);
                else if(x == 135) out[8] = new Crypto(id, name, symbol, rank, price_usd, price_btc, volume, market_cap, available_supply, total_supply, max_supply, percent_change_1h, percent_change_24h, percent_change_7d, last_updated);
                else if(x == 150) out[9] = new Crypto(id, name, symbol, rank, price_usd, price_btc, volume, market_cap, available_supply, total_supply, max_supply, percent_change_1h, percent_change_24h, percent_change_7d, last_updated);

        }
        return out;
}
public static void main(String[] args) throws IOException {
        Crypto[] ten = makeCrypto();
        System.out.println(ten[0].id);
}

public static void getCurrentLine(int i){
        int z = i + x;
        x++;

        line = in[z]; //Aktuelle Zeile
        length = line.length(); //Länge der Aktuellen Zeile
}

public static void download() throws IOException {
        in = GetData.getTopTen(); //15 Zeilen Information pro Coin
}
}
