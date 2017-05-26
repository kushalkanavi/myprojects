import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
/**
 * Created by kushalkanavi on 5/25/17.
 */
class JSONFile {

    public void jsonfile()throws FileNotFoundException,IOException{

        String filename = "/Users/kushalkanavi/Desktop/Customer.json";

        JSONParser parser = new JSONParser();
        try
        {
            Object object = parser.parse(new FileReader(filename));

            JSONObject jsonObject = (JSONObject)object;
            JSONObject AddrObj = (JSONObject)jsonObject.get("address");

            String firstname = (String) jsonObject.get("firstName");
            String lastname = (String) jsonObject.get("lastName");
            Long age = (Long) jsonObject.get("age");
            String StreetAddress = (String) AddrObj.get("streetAddress");
            String City = (String) AddrObj.get("city");
            String State = (String) AddrObj.get("state");
            String PostalCode = (String) AddrObj.get("postalCode");

            JSONArray phonenumber = (JSONArray)jsonObject.get("phoneNumber");
            JSONObject PHObj1 = (JSONObject) phonenumber.get(0);
            String Type1 = (String) PHObj1.get("type");
            String Number1 = (String) PHObj1.get("number");
            JSONObject PHObj2 = (JSONObject) phonenumber.get(1);
            String Type2 = (String) PHObj2.get("type");
            String Number2 = (String) PHObj2.get("number");

            System.out.println("FirstName: " + firstname);
            System.out.println("LastName: " + lastname);
            System.out.println("Age: " + age);
            System.out.println("Address: ");
            System.out.println("StreetAddress: " + StreetAddress);
            System.out.println("City: "+City);
            System.out.println("State: "+ State);
            System.out.println("PostalCode: "+ PostalCode);
            System.out.println("PhoneNumber: ");
            System.out.println("Type: "+ Type1);
            System.out.println("Number: "+ Number1);
            System.out.println();
            System.out.println("Type: "+ Type2);
            System.out.println("Number: "+ Number2);
        }
        catch(FileNotFoundException fe)
        {
            fe.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
