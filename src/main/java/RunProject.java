public class RunProject {

    public static void main(String[] args) throws Exception {
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        httpStatusChecker.getStatusImage(404);
        HttpImageStatusCli httpImageStatusCli = new HttpImageStatusCli();
        httpImageStatusCli.askStatus();
    }
}
