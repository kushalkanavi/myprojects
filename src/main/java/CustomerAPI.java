/**
 * Created by kushalkanavi on 5/24/17.
 */
public class CustomerAPI {

    private String lastName;

    private PhoneNumber[] phoneNumber;

    private Address address;

    private String age;

    private String firstName;

    public String getLastName ()
    {
        return lastName;
    }

    public void setLastName (String lastName)
    {
        this.lastName = lastName;
    }

    public PhoneNumber[] getPhoneNumber ()
    {
        return phoneNumber;
    }

    public void setPhoneNumber (PhoneNumber[] phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress ()
    {
        return address;
    }

    public void setAddress (Address address)
    {
        this.address = address;
    }

    public String getAge ()
    {
        return age;
    }

    public void setAge (String age)
    {
        this.age = age;
    }

    public String getFirstName ()
    {
        return firstName;
    }

    public void setFirstName (String firstName)
    {
        this.firstName = firstName;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [lastName = "+lastName+", phoneNumber = "+phoneNumber+", address = "+address+", age = "+age+", firstName = "+firstName+"]";
    }
}
