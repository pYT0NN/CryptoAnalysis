import java.io.IOException;
import java.lang.*;
public class Crypto {

String id;
String name;
String symbol;
int rank;
double price_usd;
double price_btc;
long volume;
long market_cap;
long available_supply;
long total_supply;
long max_supply;
float percent_change_1h;
float percent_change_24h;
float percent_change_7d;
long last_updated;

public Crypto(String id, String name, String symbol, int rank, double price_usd, double price_btc, long volume, long market_cap, long available_supply, long total_supply, long max_supply, float percent_change_1h, float percent_change_24h, float percent_change_7d, long last_updated){
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.rank = rank;
        this.price_usd = price_usd;
        this.volume = volume;
        this.market_cap = market_cap;
        this.available_supply = available_supply;
        this.total_supply = total_supply;
        this.max_supply = max_supply;
        this.percent_change_1h = percent_change_1h;
        this.percent_change_24h = percent_change_24h;
        this.percent_change_7d = percent_change_7d;
        this.last_updated = last_updated;
}
public Crypto(String id, String name, String symbol, int rank, double price_usd, double price_btc, long volume, long market_cap, float percent_change_1h, float percent_change_24h, float percent_change_7d, long last_updated){
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.rank = rank;
        this.price_usd = price_usd;
        this.volume = volume;
        this.market_cap = market_cap;
        this.percent_change_1h = percent_change_1h;
        this.percent_change_24h = percent_change_24h;
        this.percent_change_7d = percent_change_7d;
        this.last_updated = last_updated;
}
}
