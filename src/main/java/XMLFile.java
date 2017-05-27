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

            for(int i = 0; i < items.getLength(); ++i) {
                Node node = items.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String title = element.getElementsByTagName("title").item(0).getTextContent().trim();
                    String description = element.getElementsByTagName("description").item(0).getTextContent().trim();
                    String category = element.getElementsByTagName("category").item(0).getTextContent().trim();
                    String pubDate = element.getElementsByTagName("pubDate").item(0).getTextContent().trim();
                    System.out.println(
                            "Title : " + title + " Description : " + description + " Category : " + category +
                                    " Publish Date" + pubDate
                    );
                }
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}