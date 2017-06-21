import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

//Threads
//Queue
//Concurrent-Queue

/**
 * Created by kushalkanavi on 6/1/17.
 */

public class WebCrawler implements Runnable {

    String url;
    List<String> l = new ArrayList<String>();
    Queue<String> Q = new ConcurrentLinkedQueue<String>();

    public WebCrawler(String url) {
        this.url = url;
    }

    public void run() {
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
            Elements linksOnPage = document.select("a[href]");

            for (int i = 0; i < linksOnPage.size(); ++i) {
                Element link = linksOnPage.get(i);

                l.add(i,link.attr("abs:href"));
            }

            getpagelinks();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getpagelinks() throws InterruptedException {
        Q.add(url);

        while (!(Q.isEmpty())){

            Q.remove();
            Document document = null;
            try {
                document = Jsoup.connect(url).get();
                Elements linksOnPage = document.select("a[href]");
                Element link = linksOnPage.get(1);

                for (int j=0;j < l.size();++j){
                    Q.add(l.get(j));
                }

                String currentlink = Q.peek();
                Q.remove();
                System.out.println(Thread.currentThread().getName()+" - "+currentlink+" - "+ Q);
                url = Q.peek();
                //url = link.absUrl("abs:href");

                WebCrawler test = new WebCrawler(url);
                Thread t = new Thread(test);
                t.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}