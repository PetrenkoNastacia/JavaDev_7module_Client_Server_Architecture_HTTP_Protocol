import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;

public class HttpStatusChecker {

    String getStatusImage(int code) throws Exception {
        String imageUrl = MessageFormat.format("https://http.cat/{0}.jpg", code);
        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == 404) {
            throw new Exception("Image not found");
        }
        return imageUrl;
    }
}