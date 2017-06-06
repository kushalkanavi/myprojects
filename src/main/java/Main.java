import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by kushalkanavi on 5/19/17.
 */


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        WebCrawler test = new WebCrawler("https://www.yahoo.com");
        Thread t = new Thread(test);
        t.start();
        t.join();

        /*Document document = Jsoup.connect("https://www.yahoo.com").get();
        Elements linksOnPage = document.select("a[href]");

        for (int i=0;i<10;++i){
            Element link = linksOnPage.get(i);
            System.out.println(link.attr("abs:href"));
        }*/
    }
}