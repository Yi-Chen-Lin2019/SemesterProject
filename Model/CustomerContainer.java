package Model;
import java.util.*;

public class CustomerContainer
{
    private ArrayList<LegalPerson> customers;
    private static CustomerContainer cCon;
    private CustomerContainer()
    {
        customers = new ArrayList<>();
    }
    
    public static CustomerContainer getInstance()
    {
        if (cCon==null)
        {
            cCon=new CustomerContainer();
        }
        return cCon;
    }

    public void add(LegalPerson customer)
    {
        if(customer.getCustomer()!=null){
            customers.add(customer);
        }
    }
    public void remove(CustomerRole customer)
    {
        customers.remove(customer);
    }
    public ArrayList<LegalPerson> read()
    {
        return customers;
    }
    
    public LegalPerson getCustomer(String customerID)
    {
        Private person = null;
        for(int i = 0; i < customers.size(); i++){
            if(customers.get(i).getPhoneNumber().equals(customerID))
            {
                person = (Private)customers.get(i);
            }
        }
        return person;
    }
}