import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Created by kushalkanavi on 5/19/17.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, ParserConfigurationException {
        DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbuilder = dbfactory.newDocumentBuilder();

        try {
            Document doc = dbuilder.parse("/Users/kushalkanavi/Documents/Study Material/JAVA Programs/myprojects/src/main/resources/simple.xml");
            doc.getDocumentElement().normalize();
            NodeList Product = doc.getElementsByTagName("book");

            for (int i=0 ;i<Product.getLength();++i){
                Node node = Product.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;

                    String Author = element.getElementsByTagName("author").item(0).getTextContent().trim();
                    String Title = element.getElementsByTagName("title").item(0).getTextContent().trim();
                    String Genre = element.getElementsByTagName("genre").item(0).getTextContent().trim();
                    String Price = element.getElementsByTagName("price").item(0).getTextContent().trim();
                    String PublishDate = element.getElementsByTagName("publish_date").item(0).getTextContent().trim();
                    String Description = element.getElementsByTagName("description").item(0).getTextContent().trim();
                    String Descrepl = Description.trim().replaceAll("[\\n]           ","");

                    System.out.println("Author: "+Author);
                    System.out.println("Title: "+ Title);
                    System.out.println("Genre: "+Genre);
                    System.out.println("Price: "+Price);
                    System.out.println("Publish-Date: "+PublishDate);
                    System.out.println("Description: "+Descrepl);
                    System.out.println();
                }
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}