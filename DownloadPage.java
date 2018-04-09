import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.lang.StringBuilder;

public class DownloadPage {

public static String main(String in) throws IOException {

        // Make a URL to the web page
        URL url = new URL(in);

        // Get the input stream through URL Connection
        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();

        // Once you have the Input Stream, it's just plain old Java IO stuff.

        // For this case, since you are interested in getting plain-text web page
        // I'll use a reader and output the text content to System.out.

        // For binary content, it's better to directly read the bytes from stream and write
        // to the target file.


        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line = null;
        StringBuilder current = new StringBuilder();

        // read each line and write to the current String
        while ((line = br.readLine()) != null) {
                current.append(line + "\n");
        }
        String output = current.toString(); //Convert current to output String
        return output;
}
}
