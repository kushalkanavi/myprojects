/**
 * Created by kushalkanavi on 5/24/17.
 */
public class Address
{
    private String streetAddress;

    private String postalCode;

    private String state;

    private String city;

    public String getStreetAddress ()
    {
        return streetAddress;
    }

    public void setStreetAddress (String streetAddress)
    {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode ()
    {
        return postalCode;
    }

    public void setPostalCode (String postalCode)
    {
        this.postalCode = postalCode;
    }

    public String getState ()
    {
        return state;
    }

    public void setState (String state)
    {
        this.state = state;
    }

    public String getCity ()
    {
        return city;
    }

    public void setCity (String city)
    {
        this.city = city;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [streetAddress = "+streetAddress+", postalCode = "+postalCode+", state = "+state+", city = "+city+"]";
    }
}
