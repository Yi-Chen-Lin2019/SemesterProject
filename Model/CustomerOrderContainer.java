package Model;
import java.util.*;

public class CustomerOrderContainer
{
    private ArrayList<CustomerOrder> orders;
    private static CustomerOrderContainer instance;
    
    private CustomerOrderContainer()
    {
        orders = new ArrayList<>();
    }
    
    public static CustomerOrderContainer getInstance()
    {
        if(instance == null)
        {
            instance = new CustomerOrderContainer();
        }
        return instance;
    }
    public void add(CustomerOrder order)
    {
        orders.add(order);
    }
    public void remove(CustomerOrder order)
    {
        orders.remove(order);
    }
    public ArrayList<CustomerOrder> read()
    {
        return orders;
    }
}
