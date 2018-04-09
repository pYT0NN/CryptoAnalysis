import java.io.IOException;
public class GetData {

static String moneroURL = "https://api.coinmarketcap.com/v1/ticker/monero/";
static String topTenURL = "https://api.coinmarketcap.com/v1/ticker/?limit=10";
static String monero;
static String topTen;
static String[] monero_split;
static String[] topTen_split;

public static void downloadMonero() throws IOException {
        monero = DownloadPage.main(moneroURL); //Download der Seite
        monero_split = monero.split("[\r\n]+"); //Splitten der Seitenzeile in einzelne Strings
}
public static void downloadTopTen() throws IOException {
        topTen = DownloadPage.main(topTenURL);
        topTen_split = topTen.split("[\r\n]+");

}
public static String[] getMonero() throws IOException {

        downloadMonero();
        int n = monero_split.length;
        String[] current_Monero = new String[n]; //neues Array welches nur relevante Infos enthält
        int k = 0;

        for(int i = 0; i < n; i++) {
                try{    //wenn die Zeile lediglich eine Klammer enthält wird sie nicht beachtet
                        if(monero_split[i].substring(0, 1).equals("[") || monero_split[i].substring(0, 1).equals("]")) {}
                        if(monero_split[i].substring(4, 5).equals("{") || monero_split[i].substring(4, 5).equals("}")) {}

                        else{  //Ansonsten remove Whitespace und füge die Zeile in dem neuen Array ein
                                int length = monero_split[i].length();
                                current_Monero[k++] = monero_split[i].substring(9, length);
                        }
                }
                catch(Exception e) {

                }
        }
        int count = 0;
        while(current_Monero[count] != null) count++; //Null Zeilen entfernen

        String[] out_Monero = new String[count];
        for(int i = 0; i < count; i++) {
                out_Monero[i] = current_Monero[i];
        }
        return out_Monero;
}

public static String[] getTopTen() throws IOException {

        downloadTopTen();
        int n = topTen_split.length;
        String[] current_topTen = new String[n]; //neues Array welches nur relevante Infos enthält
        int k = 0;

        for(int i = 0; i < n; i++) {
                try{    //wenn die Zeile lediglich eine Klammer enthält wird sie nicht beachtet
                        if(topTen_split[i].substring(0, 1).equals("[") || topTen_split[i].substring(0, 1).equals("]")) {}
                        if(topTen_split[i].substring(4, 5).equals("{") || topTen_split[i].substring(4, 5).equals("}")) {}

                        else{  //Ansonsten remove Whitespace und füge die Zeile in dem neuen Array ein
                                int length = topTen_split[i].length();
                                current_topTen[k++] = topTen_split[i].substring(9, length);
                        }
                }
                catch(Exception e) {

                }
        }
        int count = 0;
        while(current_topTen[count] != null) count++; //Null Zeilen entfernen

        String[] out_topTen = new String[count];
        for(int i = 0; i < count; i++) {
                out_topTen[i] = current_topTen[i];
        }
        return out_topTen; //Enthält 15 zeilen pro Coin => Alle 15 Zeilen beginnt ein neuer Coin
}

public static void main(String[] args)  throws IOException {

        String[] test_topTen = getTopTen();
        int n = test_topTen.length;

        for(int i = 0; i < n; i++) {
                System.out.println(test_topTen[i]);
        }

}
}
