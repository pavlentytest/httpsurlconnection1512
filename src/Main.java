import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        String url = "https://predictor.yandex.net/api/v1/predict.json/complete?key=072&q="+word+"&lang=en&limit=5";
        HttpsURLConnection connection;
        URL u = new URL(url);
        connection = (HttpsURLConnection) u.openConnection();
        connection.setConnectTimeout(10000);
        connection.connect();
        // http server codes
        int code = connection.getResponseCode();
        System.out.println("Response code: "+code);
        scanner = new Scanner(connection.getInputStream());
        String result = scanner.nextLine();
        System.out.println(result);
        // JSON
        // {
        //     "endOfWord": true,
        //      "pos"     :  1,
        //      "text"    :  ["russia","and","inn","the","to"]
        //  }
        // Java Script Object Notation
    }
}