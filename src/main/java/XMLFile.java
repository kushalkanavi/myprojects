import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
/**
 * Created by kushalkanavi on 5/26/17.
 */
public class XMLFile {
    public XMLFile() throws ParserConfigurationException {
        DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbfactory.newDocumentBuilder();
        try {
            Document doc = dBuilder.parse("/Users/kushalkanavi/Documents/Study Material/JAVA Programs/myprojects/src/main/resources/project.xml");
            doc.getDocumentElement().normalize();
            NodeList items = doc.getElementsByTagName("item");
            NodeList media = doc.getElementsByTagName("media:thumbnail");

            int  mediainit=0,mediacomp =6;
            int  iteminit =0,itemcomp =1;


            for (int k=0;k<items.getLength();++k){

                for (int i = mediainit; i < mediacomp; ++i) {
                    Node mnode = media.item(i);
                    if (mnode.getNodeType() == Node.ELEMENT_NODE) {
                        Element melement = (Element) mnode;

                        String URL = melement.getAttribute("url");
                        String Width = melement.getAttribute("width");
                        String Length = melement.getAttribute("height");
                        String Credit = melement.getAttribute("credit");

                        System.out.println("URL: "+ URL+" | Width: "+ Width+" | Length: "+ Length+" | Credit: "+ Credit);
                    }
                }
                mediainit += 6; mediacomp +=6;

                for (int j=iteminit;j<itemcomp;++j){
                    Node node = items.item(j);
                    if (node.getNodeType() == Node.ELEMENT_NODE){
                        Element element = (Element) node;

                        String title = element.getElementsByTagName("title").item(0).getTextContent().trim();
                        String description = element.getElementsByTagName("description").item(0).getTextContent().trim();
                        String category = element.getElementsByTagName("category").item(0).getTextContent().trim();
                        String pubDate = element.getElementsByTagName("pubDate").item(0).getTextContent().trim();

                        System.out.println(
                                "Title : " + title + " Description : " + description + " Category : " + category +
                                        " Publish Date" + pubDate);
                    }
                }
                iteminit += 1; itemcomp += 1;
                System.out.println();
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}