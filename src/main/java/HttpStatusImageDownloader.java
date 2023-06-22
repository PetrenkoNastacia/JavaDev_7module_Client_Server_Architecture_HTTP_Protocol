import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;

public class HttpStatusImageDownloader {

    private final HttpStatusChecker httpStatusChecker;

    public HttpStatusImageDownloader() {
        httpStatusChecker = new HttpStatusChecker();
    }

    public void downloadStatusImage(int code) throws Exception {
        String imageUrl = httpStatusChecker.getStatusImage(code);
        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == 404) {
            throw new RuntimeException(MessageFormat.format("Image not found for code{0}", code));
        }

        InputStream inputStream = connection.getInputStream();
        String fileName = code + ".jpg";
        FileOutputStream outputStream = new FileOutputStream(fileName);

        byte[] buffer = new byte[2048];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, length);
        }
        outputStream.close();
        inputStream.close();
    }
}