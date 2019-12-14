package Control;
import Model.*;


public class OrderController
{
    private static OrderController instance;
    private CustomerOrderContainer orders;
    private OrderLineController olController = new OrderLineController();
    
    public OrderController()
    {
        orders = CustomerOrderContainer.getInstance();
        
    }
    
    public static OrderController getInstance()
    {
        if(instance == null)
        {
            instance = new OrderController();
        }
        return instance;
    }
    public int createOrder(String orderedDate, EmployeeRole employee, CustomerRole customer)
    {
        CustomerOrder order = new CustomerOrder(orderedDate, "Not delivered yet", employee, "waiting for confirmation", customer);
        orders.add(order);
        return order.getOrderID();
    }
    public CustomerOrder findOrder(int id)
    {
        for(CustomerOrder order : orders.read())
        {
            if(order.getOrderID() == id)
            {
                return order;
            }
        }
        return null;
    }
    
    public boolean cancelOrder(int id)
    {
        for(CustomerOrder order : orders.read())
        {
            if(order.getOrderID() == id)
            {
                orders.remove(order);
                return true;
            }
        }
        return false;
    }
    public void updateOrderStatus(String status,int id)
    {
        for(CustomerOrder order : orders.read())
        {
            if(order.getOrderID() == id)
            {
                order.setStatus(status);
            }
        }
    }
    public void updateOrderDeliveryDate(String deliveryDate,int id)
    {
        for(CustomerOrder order : orders.read())
        {
            if(order.getOrderID() == id)
            {
                order.setDeliveryDate(deliveryDate);
            }
        }
    }
}
