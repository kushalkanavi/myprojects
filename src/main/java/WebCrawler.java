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

    public List<String> getL() {
        return l;
    }

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
                Element link = linksOnPage.get(0);

                for (int j=0;j < l.size();++j){
                    Q.add(l.get(j));
                }

                String currentlink = Q.peek();
                Q.remove();
                System.out.println(Thread.currentThread().getName()+" - "+currentlink+" - "+ Q);
                url = Q.peek();

                WebCrawler test = new WebCrawler(url);
                Thread t = new Thread(test);
                t.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

/*public class WebCrawler{
    Queue <String> Q = new ConcurrentLinkedQueue<String>();
    String url;

    public WebCrawler(String url) {
        this.url = url;
    }

    public void getpagelinks()  {

        Q.add(url);

        while (!(Q.isEmpty())){
            Document document = null;
            try {
                document = Jsoup.connect(url).get();
                Elements linksOnPage = document.select("a[href]");
                Element link = linksOnPage.get(0);

                webcrawlerthread test = new webcrawlerthread(link.attr("abs:href"));
                Thread t = new Thread(test);



                List<String> al = test.getL();

                for (int j=0;j < al.size();++j){
                    Q.add(al.get(j));
                }

                String currentlink = Q.peek();
                Q.remove();
                System.out.println(Thread.currentThread().getName()+" - "+currentlink+" - "+ Q);
                url = Q.peek();

                t.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}*/

/*class webcrawlerthread implements Runnable{

    private  String url;
    List <String> l = new ArrayList<String>();


    public webcrawlerthread(String url) {
        this.url = url;
    }

    public List<String> getL() {
        return l;
    }

    public void run() {

        Document document = null;
        try {
            document = Jsoup.connect(url).get();
            Elements linksOnPage = document.select("a[href]");

            for (int i=0;i<linksOnPage.size();++i){
                Element link = linksOnPage.get(i);

                l.add(link.attr("abs:href"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        url = l.get(1);

        WebCrawler test = new WebCrawler(url);
        test.getpagelinks();
    }
}*/

/*public class WebCrawler {
    Queue <String> q = new ConcurrentLinkedQueue<String>();
    String url;

    public WebCrawler(String url){
        this.url = url;
    }

    public String getpagelinks(){
            q.add(url);
            Document document = null;
                try {
                    document = Jsoup.connect(q.peek()).get();
                    Elements linksOnPage = document.select("a[href]");


                    for (int i=0;i<linksOnPage.size();++i){
                        Element link = linksOnPage.get(i);

                        if (!(q.peek().equals(link.attr("abs:href")))){
                            q.add(link.attr("abs:href"));
                        }
                        else
                            q.remove(link.attr("abs:href"));
                    }
                    String currentlink = q.peek();
                    q.remove();

                    System.out.println(Thread.currentThread().getName()+" - "+currentlink+" - "+q);

                    url = q.peek();
                    System.out.println(url);

                    webcrawlerthread test = new webcrawlerthread(url);
                    Thread t = new Thread(test);

                    t.start();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return url;
    }
}*/

/*class webcrawlerthread implements Runnable{

    private  String url;

    public webcrawlerthread(String url) {
        this.url = url;
    }

    public void run() {
        WebCrawler wc = new WebCrawler(url);
        url = wc.getpagelinks();
    }
}*/