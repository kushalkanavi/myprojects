import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

//Threads
//Queue
//Concurrent-Queue

/**
 * Created by kushalkanavi on 6/1/17.
 */

public class WebCrawler implements Runnable{
    Queue <String> q = new LinkedList<String>();
    String url;

    public WebCrawler(String url){
        this.url = url;
    }

    public String getpagelinks(){

        while (!(q.isEmpty())){

            //Document document = null;
            try {
                Document document = Jsoup.connect(q.peek()).get();
                Elements linksOnPage = document.select("a[href]");

                for (int i=0;i<linksOnPage.size();++i){
                    Element link = linksOnPage.get(i);
                    if (!(q.peek().equals(link.attr("abs:href")))){
                        q.add(link.attr("abs:href"));

                    }
                    else
                        q.remove(link.attr("abs:href"));
                }

                WebCrawler test = new WebCrawler(q.peek());
                Thread t = new Thread(test);
                t.start();

                System.out.println(Thread.currentThread().getName()+" - "+q);

                url = q.peek();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return url;
    }

    public void run() {
        q.add(url);
        getpagelinks();
    }
}