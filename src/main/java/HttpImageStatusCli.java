import java.util.Scanner;

public class HttpImageStatusCli {

    private final HttpStatusImageDownloader httpStatusImageDownloader;
    private static int clientInput;

    public HttpImageStatusCli(){
        httpStatusImageDownloader = new HttpStatusImageDownloader();
    }

    public void askStatus() {
        System.out.println("Enter HTTP status code: ");
        try (Scanner sc = new Scanner(System.in)) {
            if (sc.hasNextInt()) {
                clientInput = sc.nextInt();
            } else {
                System.out.println("Please enter valid number!");
            }
            try {
                httpStatusImageDownloader.downloadStatusImage(clientInput);
            } catch (Exception e) {
                System.out.println("There's no image for status code " + clientInput);
            }
        }
    }
}
