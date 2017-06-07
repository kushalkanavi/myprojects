import java.io.IOException;

/**
 * Created by kushalkanavi on 5/19/17.
 */

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        WebCrawler test = new WebCrawler("https://www.yahoo.com");
        Thread t = new Thread(test);
            t.start();
            //t.join();
    }
}