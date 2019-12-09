package Model;
import java.util.*;

public class CustomerContainer
{
    private ArrayList<CustomerRole> customers;
    private static CustomerContainer instance;
    
    private CustomerContainer()
    {
        customers = new ArrayList<>();
    }

    public static CustomerContainer getInstance()
    {
        if(instance == null)
        {
            instance = new CustomerContainer();
        }
        return instance;
    }
    public void add(CustomerRole customer)
    {
        customers.add(customer);
    }
    public void remove(CustomerRole customer)
    {
        customers.remove(customer);
    }
    public ArrayList<CustomerRole> read()
    {
        return customers;
    }
}